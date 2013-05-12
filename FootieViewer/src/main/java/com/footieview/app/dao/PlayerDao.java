package com.footieview.app.dao;

import java.util.List;

import com.footieview.app.entity.Player;


public interface PlayerDao {
	
	public Player getByUuid(String uuid);
	public List<Player> getByName(String name);
	public void addPlayer(Player player);
	public List<Player> getAll();
	public void addAllPlayers(List<Player> players);
}
