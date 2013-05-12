package com.footieview.app.dao;

import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.footieview.app.entity.Player;

@Repository("playerDao")
public class PlayerDaoImpl implements PlayerDao {
	@Autowired
	private SessionFactory sessionFactory;

	private static final Logger logger = Logger.getLogger(PlayerDaoImpl.class);

	@Override
	public Player getByUuid(final String uuid) {
		return (Player) sessionFactory.getCurrentSession().get(Player.class,
				uuid);
	}

	@Override
	public void addPlayer(final Player player) {
		sessionFactory.getCurrentSession().save(player);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Player> getAll() {
		return (List<Player>) sessionFactory.getCurrentSession()
				.createQuery("FROM Player").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Player> getByName(final String name) {
		logger.log(Level.DEBUG, "Searching for : " + name);
		final String space = " ";
		return (List<Player>) sessionFactory
				.getCurrentSession()
				.createQuery(
						"FROM Player WHERE firstName LIKE :name " +
						"OR lastName LIKE :name " +
						"OR CONCAT(CONCAT(firstName, :space), lastName) LIKE :name ")
				.setParameter("name", '%' + name + '%')
				.setParameter("space", space).list();
	}

	@Override
	public void addAllPlayers(final List<Player> players) {
		for (final Player player : players) {
			addPlayer(player);
		}
	}

}
