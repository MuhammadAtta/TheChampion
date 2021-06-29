package com.tennis_table.league.champion.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tennis_table.league.champion.model.Round;
import com.tennis_table.league.champion.service.IRoundsService;

@RestController
@RequestMapping(path="/api/rounds",produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
public class RoundsController {

	private Logger logger=LoggerFactory.getLogger(RoundsController.class);
	
	@Autowired
	private IRoundsService roundsService;
	
	/**
	 * Get list of all automatically created the first-round matches
	 * @param roundNo
	 * @return
	 */
	@GetMapping("/{roundNo}")
	public ResponseEntity<List<Round>> findAllMatchesByRoundNo(@PathVariable(name="roundNo",required=true) int roundNo)
	{
		logger.info("@method findAllMatchesByRoundNo");

		return ResponseEntity.ok(roundsService.findAllMatchesByRoundNo(roundNo));
	}
	/**
	 * Close round
	 * @param roundId
	 * @return
	 */
	@PutMapping("/{roundId}")
	public ResponseEntity<String> closeRound(@PathVariable(name="roundId",required=true) Long roundId)
	{
		logger.info("@method closeRound");

		return ResponseEntity.ok(roundsService.closeRound(roundId));
	}
}
