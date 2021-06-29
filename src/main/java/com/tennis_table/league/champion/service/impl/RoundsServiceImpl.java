package com.tennis_table.league.champion.service.impl;

import java.util.List;
import java.util.Optional;

import com.tennis_table.league.champion.model.Match;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.tennis_table.league.champion.exceptions.UnexpectedServerErrorException;
import com.tennis_table.league.champion.model.Round;
import com.tennis_table.league.champion.model.Round.RoundStatus;
import com.tennis_table.league.champion.repository.IRoundRepository;
import com.tennis_table.league.champion.service.IRoundsService;
import com.tennis_table.league.champion.utils.MessageUtils;

@Service
public class RoundsServiceImpl implements IRoundsService{

	Logger logger=LoggerFactory.getLogger(RoundsServiceImpl.class);

	@Autowired
	private IRoundRepository roundRepository;


	@Override
	public List<Round> findAllMatchesByRoundNo(int roundNo) 
	{
		logger.info("@method findAllMatchesByRoundNo");
		return roundRepository.findByRoundNo(roundNo);
	}


	/* (non-Javadoc)
	 * @see com.tennis_table.league.champion.service.IRoundsService#closeRound(int)
	 */
	@Override
	public String closeRound(Long roundId) 
	{
		logger.info("@method closeRound");
		Optional<Round> optionalRound=roundRepository.findById(roundId);

		if(optionalRound.isPresent())
		{
			Round round=optionalRound.get();
			if(!CollectionUtils.isEmpty(round.getMatches()))
			{
				Optional<Match> matches=round.getMatches().stream().filter(m->m.getWinner()==null).findFirst();
				if(matches.isPresent())
				{
					throw new UnexpectedServerErrorException(MessageUtils.MATCH_WINNER_IS_NOT_UPDATED_YET);
				}
				round.setRoundStatus(RoundStatus.CLOSE);
				roundRepository.save(round);
				return MessageUtils.ROUND_CLOSED_SUCCESSFULLY;
			}
		}

		return MessageUtils.UNABLE_TO_FIND_ROUND;
	}


	@Override
	public Round createRound(Round round) 
	{
		return roundRepository.save(round);
	}

}
