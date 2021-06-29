package com.tennis_table.league.champion.controller;

import java.util.List;

import com.tennis_table.league.champion.model.Match;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tennis_table.league.champion.service.IMatchesService;

@RestController
@RequestMapping(path="/api/match",produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
public class MatchController {

	private Logger logger=LoggerFactory.getLogger(MatchController.class);

	@Autowired
	private IMatchesService matchesService;

	/**
	 * Get a list of all participants
	 * @return
	 */
	@GetMapping
	public ResponseEntity<List<Match>> findAllMatches()
	{
		logger.info("@method findAllMatches");

		return ResponseEntity.ok(matchesService.findAllMatches());
	}

	/**
	 * Update match winner and results
	 * @param match
	 * @return
	 */
	@PutMapping("/updateMatch")
	public ResponseEntity<String> updateMatchWinnerAndResult(@RequestBody Match match)
	{
		logger.info("@method updateMatchWinnerAndResult");
		return ResponseEntity.ok(matchesService.updateMatchWinnerAndResult(match));
	}
}

