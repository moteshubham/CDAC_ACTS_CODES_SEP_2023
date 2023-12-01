package com.app.controlller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.service.TeamService;

@Controller
public class TeamController {

	@Autowired
	private TeamService teamService;

	public TeamController() {
		System.out.println("in ctor of team controller");
	}

	@RequestMapping("/test")

	public String showFormPage(Model model) {
		List<String> allTeamsAbbr = teamService.getAllTeamsAbbr();
		model.addAttribute("teamsAbbr", allTeamsAbbr); // saved under request scope
		return "/teams/add_player_form"; /// AVN: /WEB-INF/views/teams/add_player_form
	}
}
