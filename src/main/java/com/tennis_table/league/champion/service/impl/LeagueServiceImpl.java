package com.tennis_table.league.champion.service.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.tennis_table.league.champion.exceptions.NoParticipantFound;
import com.tennis_table.league.champion.model.League;
import com.tennis_table.league.champion.repository.ILeagueRepository;
import com.tennis_table.league.champion.service.ILeagueService;
import com.tennis_table.league.champion.service.IMatchesService;
import com.tennis_table.league.champion.utils.CommonUtils;
import com.tennis_table.league.champion.utils.MessageUtils;

@Service
public class LeagueServiceImpl implements ILeagueService{

	Logger logger=LoggerFactory.getLogger(LeagueServiceImpl.class);

	@Autowired
	private ILeagueRepository leagueRepository;

	@Autowired
	private IMatchesService matchService;
	
	@Autowired
	private JavaMailSender javaMailSender;


	@Override
	public String createLeague(League league) 
	{
		logger.info("@method createLeague");
		if(CollectionUtils.isEmpty(league.getParticipants()))
		{
			throw new NoParticipantFound();
		}
		int size=league.getParticipants().size();
		if(size>12)
		{
			throw new NoParticipantFound(MessageUtils.PARTICIPANTS_NOT_MORE_THAN_12);
		}
		League persistentLeague=new League();
		persistentLeague.setStartDate(league.getStartDate());
		persistentLeague.setName(league.getName());
		persistentLeague=leagueRepository.save(persistentLeague);
		int noOfTotalMatches=CommonUtils.calculateNoOfMatchesBasedOnParticipants(size);
		int noOfRounds=CommonUtils.calculateNoOfRounds(size);
		int noOfMatchesPerRound=CommonUtils.calculateNoOfMatchesPerRound(noOfTotalMatches,noOfRounds);
		matchService.createMatches(league.getParticipants(), noOfTotalMatches, noOfRounds, noOfMatchesPerRound, persistentLeague);
		return MessageUtils.LEAGUE_CREATED_SUCCESSFULLY;
	}


	/* (non-Javadoc)
	 * @see com.tennis_table.league.champion.service.ILeagueService#updateLeagueChampion(com.tennis_table.league.champion.model.League)
	 */
	@Override
	public String updateLeagueChampion(League league) {
		logger.info("@method updateLeagueChampion");

		Optional<League> leagueOpt=leagueRepository.findById(league.getLeagueId());
		if(leagueOpt.isPresent())
		{
			League persistendLeague=leagueOpt.get();
			persistendLeague.setWinner(league.getWinner());
			leagueRepository.save(persistendLeague);
			sendMail(league.getWinner().getEmail());
			return MessageUtils.CHAMPION_UPDATED_SUCCESSFULLY;
		}else
		{
			return MessageUtils.NO_LEAGUE_FOUND;
		}
	}


	/**
	 * Create a new model for ‘Congratulation Mail’ to be sent to the champion.
	 * @param emailId
	 */
	private void sendMail(String emailId) {
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(emailId);
		msg.setSubject("Congratulation Mail");
		msg.setText("Hi I congratulate on winning the league Keep the pace UP!");
		javaMailSender.send(msg);
	}


}
