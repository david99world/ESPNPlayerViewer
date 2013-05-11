package com.footieview.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.footieview.app.entity.Player;
import com.footieview.app.service.PlayerService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class PlayerController {
	@Autowired PlayerService playerService;
//	private static final Logger logger = LoggerFactory.getLogger(PlayerController.class);
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "home";
	}
	
	@RequestMapping(value = "/getPlayers", method = RequestMethod.GET)
	@ResponseBody
	public List<Player> getPlayers(String playerName) {
		return playerService.getByName(playerName);
	}
	
}
