package com.tennis_table.league.champion.service;

import java.util.List;

import com.tennis_table.league.champion.model.League;
import com.tennis_table.league.champion.model.Match;
import com.tennis_table.league.champion.model.Participant;

public interface IMatchesService {

	/**
	 * @param noOfMatchesPerRound 
	 * @param noOfRounds 
	 * @param noOfTotalMatches 
	 * @param participants 
	 * @param league 
	 */
	void createMatches(List<Participant> participants, int noOfTotalMatches, int noOfRounds, int noOfMatchesPerRound, League league);

	/**
	 * @return
	 */
	List<Match> findAllMatches();

	/**
	 * Update match winner and results
	 * @param match
	 * @return
	 */
	String updateMatchWinnerAndResult(Match match);
	
}
