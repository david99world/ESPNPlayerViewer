package com.footieview.app.service;

import java.util.List;

import com.footieview.app.entity.Player;


public interface PlayerService {
	public Player getByUuid(String uuid);
	public List<Player> getByName(String name);
	public void addPlayer(Player player);
	public List<Player> getAll();
	public void addAllPlayers(List<Player> players);
}
