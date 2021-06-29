package com.tennis_table.league.champion.utils;

public class CommonUtils {

	private CommonUtils(){}
	/**
	 * calculate No Of Match Based On Participant
	 * @param n
	 * @return
	 */
	public static int calculateNoOfMatchesBasedOnParticipants(int n) {
		return n*(n-1)/2;
	}

	/**
	 * calculate No Of Rounds
	 * @param size
	 * @return
	 */
	public static int calculateNoOfRounds(int size) 
	{	
		return size%2==0?size-1: size;
	}

	/**
	 * calculate No Of Match Per Round
	 * @param noOfTotalMatches
	 * @param noOfRounds
	 * @return
	 */
	public static int calculateNoOfMatchesPerRound(int noOfTotalMatches, int noOfRounds) 
	{
		return noOfTotalMatches/noOfRounds;
	}
}
