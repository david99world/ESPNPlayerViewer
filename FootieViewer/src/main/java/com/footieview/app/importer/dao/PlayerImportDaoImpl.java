package com.footieview.app.importer.dao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.footieview.app.entity.Player;
import com.footieview.app.service.PlayerService;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class PlayerImportDaoImpl implements PlayerImportDao {

	private static final String API_KEY = "KEY";
	private static final String API_URL = "http://api.espn.com/v1/sports/soccer/eng.1/athletes?apikey=";

	@Autowired
	private PlayerService playerService;

	@Override
	@PostConstruct
	public void importPlayers() {
		System.out.println("*****importing players");
		final List<Player> players = new LinkedList<>();
		for (int offset = 1; offset < 650; offset = offset + 50) {
			try {
				final JsonArray athletes = getAthletesJsonArray(offset);
				for (final JsonElement athleteJsonElement : athletes) {
					JsonObject athleteJsonObject = athleteJsonElement
							.getAsJsonObject();
					final Player player = new Player();
					player.setEspnId(athleteJsonObject.get("id").getAsInt());
					player.setFirstName(athleteJsonObject.get("firstName")
							.getAsString());
					player.setLastName(athleteJsonObject.get("lastName")
							.getAsString());
					player.setEspnUrl(athleteJsonObject.get("links")
							.getAsJsonObject().get("web").getAsJsonObject()
							.get("athletes").getAsJsonObject().get("href")
							.getAsString());
					players.add(player);
				}

				Thread.sleep(150);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		playerService.addAllPlayers(players);

	}

	private static JsonArray getAthletesJsonArray(final int offset)
			throws Exception {
		final String json = readUrl(getUrl(offset));
		final JsonArray sports = getSportsJsonArray(json);
		final JsonElement league = sports.get(0);
		return league.getAsJsonObject().get("leagues").getAsJsonArray().get(0)
				.getAsJsonObject().get("athletes").getAsJsonArray();
	}

	private static JsonArray getSportsJsonArray(final String json) {
		final JsonArray sports = new JsonParser().parse(json).getAsJsonObject()
				.get("sports").getAsJsonArray();
		return sports;
	}

	private static String getUrl(final int offset) {
		return API_URL + API_KEY + "&offset=" + offset;
	}

	private static String readUrl(final String urlString) throws Exception {
		BufferedReader reader = null;
		try {
			final URL url = new URL(urlString);
			reader = new BufferedReader(new InputStreamReader(url.openStream()));
			final StringBuffer buffer = new StringBuffer();
			int read;
			final char[] chars = new char[1024];
			while ((read = reader.read(chars)) != -1) {
				buffer.append(chars, 0, read);
			}
			return buffer.toString();
		} finally {
			if (reader != null) {
				reader.close();
			}
		}
	}

}
