package com.app.controlller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.pojos.Player;
import com.app.service.PlayerService;

@Controller
@RequestMapping("/players")
public class PlayerController {

	
	@Autowired
	private PlayerService playerService;
	
	@PostMapping("/add")
	public String addPlayer(@RequestParam String abbr,@RequestParam String fn, @RequestParam String ln, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dob, @RequestParam Double avg, @RequestParam int wickets, Model map ) {
		System.out.println("in addPlayer()");
		Player newPlayer = new Player(fn, ln, dob, avg, wickets);
		String addPlayerToTeam = playerService.addPlayerToTeam(newPlayer, abbr);
		
		return addPlayerToTeam;
		
	}
	
}
