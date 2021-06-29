package com.tennis_table.league.champion.service.impl;

import java.util.List;

import com.tennis_table.league.champion.model.Participant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tennis_table.league.champion.repository.IParticipantsRepository;
import com.tennis_table.league.champion.service.IParticipantsService;
import com.tennis_table.league.champion.utils.MessageUtils;

@Service
public class ParticipantsServiceImpl implements IParticipantsService{

	private Logger logger=LoggerFactory.getLogger(ParticipantsServiceImpl.class);
	
	@Autowired
	private IParticipantsRepository participantsRepository;
	
	
	/* (non-Javadoc)
	 * @see com.tennis_table.league.champion.service.IParticipantsService#createParticipants(com.tennis_table.league.champion.model.Participant)
	 */
	@Override
	public String createParticipants(Participant participant) {
		
		logger.info("@method createParticipants");
		participantsRepository.save(participant);
		return MessageUtils.PARTICIPANTS_CREATED_SUCCESSFULLY;
	}

	/* (non-Javadoc)
	 * @see com.tennis_table.league.champion.service.IParticipantsService#findAllParticipants()
	 */
	@Override
	public List<Participant> findAllParticipants() {
	
		logger.info("@method findAllParticipants");
		return participantsRepository.findAll();
	}

}
