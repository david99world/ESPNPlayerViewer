package com.footieview.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.footieview.app.dao.PlayerDao;
import com.footieview.app.entity.Player;


@Service("playerService")
public class PlayerServiceImpl implements PlayerService {

	@Autowired
	private PlayerDao playerDao;
	
	@Override
	public Player getByUuid(final String uuid) {
		return playerDao.getByUuid(uuid);
	}
	

	@Override
	@Transactional
	public void addPlayer(Player player) {
		playerDao.addPlayer(player);
	}

	@Override
	@Transactional
	public List<Player> getAll() {
		return playerDao.getAll();
	}


	@Override
	@Transactional
	public List<Player> getByName(String name) {
		return playerDao.getByName(name);
	}


	@Override
	@Transactional
	public void addAllPlayers(List<Player> players) {
		playerDao.addAllPlayers(players);
	}

}
