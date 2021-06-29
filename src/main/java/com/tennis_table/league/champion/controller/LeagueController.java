package com.tennis_table.league.champion.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tennis_table.league.champion.model.League;
import com.tennis_table.league.champion.service.ILeagueService;

@RestController
@RequestMapping(path="/api/league",produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
public class LeagueController {

	
	private Logger logger=LoggerFactory.getLogger(LeagueController.class);

	@Autowired
	private ILeagueService leagueService;
	
	/**
	 * Submit a request of new match (players and time)
	 * @param league
	 * @return
	 */
	@PostMapping
	public ResponseEntity<String> createLeague(@RequestBody League league)
	{
		logger.info("@method createLeague");
		return ResponseEntity.ok(leagueService.createLeague(league));
	}

	/**
	 * Submit league champion
	 * @param league
	 * @return
	 */
	@PutMapping
	public ResponseEntity<String> updateLeagueChampion(@RequestBody League league)
	{
		logger.info("@method updateLeagueChampion");
		return ResponseEntity.ok(leagueService.updateLeagueChampion(league));
	}


}
