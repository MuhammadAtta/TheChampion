package com.tennis_table.league.champion.exceptions;

public class NoParticipantFound extends RuntimeException {

	public NoParticipantFound() {
		super("No Participant found");
	}

	public NoParticipantFound(String msg) {
		super(msg);
	}
}
