package com.tennis_table.league.champion.service;

import java.util.List;

import com.tennis_table.league.champion.model.Participant;

public interface IParticipantsService {

	/**
	 * @param participant
	 * @return
	 */
	String createParticipants(Participant participant);

	/**
	 * @return
	 */
	List<Participant> findAllParticipants();

}
