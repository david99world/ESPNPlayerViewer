package com.footieview.app.service;

import java.util.List;

import com.footieview.app.entity.Player;


public interface PlayerService {
	/**
	 * This method will return a player with this uuid.
	 * 
	 * @param uuid of the player in question.
	 * @return a player object.
	 */
	public Player getByUuid(String uuid);
	
	/**
	 * Return all players with a similar name to the paramter.
	 * 
	 * @param name searching for.
	 * @return all players with that name.
	 */
	public List<Player> getByName(String name);
	
	/**
	 * Add a single player to the database.
	 * 
	 * @param player to be persisted.
	 */
	public void addPlayer(Player player);
	
	/**
	 * Get all players in the database.
	 * 
	 * @return a list of players in the database.
	 */
	public List<Player> getAll();
	
	/**
	 * Send a list of players to the be persisted.
	 * 
	 * @param players list to be persisted.
	 */
	public void addAllPlayers(List<Player> players);
}
