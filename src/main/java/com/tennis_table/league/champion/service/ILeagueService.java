package com.tennis_table.league.champion.service;

import com.tennis_table.league.champion.model.League;

public interface ILeagueService {

	/**
	 * create League
	 * @param league
	 * @return
	 */
	String createLeague(League league);

	/**
	 * @param league
	 * @return
	 */
	String updateLeagueChampion(League league);

}
