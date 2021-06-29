package com.tennis_table.league.champion.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.tennis_table.league.champion.model.Match;
import com.tennis_table.league.champion.model.Participant;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.tennis_table.league.champion.model.Round;
import com.tennis_table.league.champion.model.Round.RoundStatus;
import com.tennis_table.league.champion.repository.IRoundRepository;
import com.tennis_table.league.champion.service.impl.RoundsServiceImpl;

@ExtendWith(MockitoExtension.class)
public class RoundsServiceImplTest {

	@InjectMocks
	private RoundsServiceImpl roundServiceImpl;
	
	@Mock
	private IRoundRepository roundRepository;
	
	private Participant player1;
	private Participant player2;
	private Round round;
    
    private List<Match> matchList =new ArrayList<>();
    private Match match;
    private List<Round> roundList=new ArrayList<>();
    
	
    @BeforeEach
	public void setup()
	{
    	match=new Match((long) 1, player1, player2, round, LocalDate.now(), "2-1,3-2", null, null);
    	
    	player1=new Participant((long) 1, "Muhammad", "muhammad.abdelmageed@mail.com", 1, "+919754258264");
    	player2=new Participant((long) 2, "Mark", "m@mail.com", 2, "+919754258164");
    	matchList.add(match);
    	round=new Round((long)1, "Round 1", 1, RoundStatus.NEW, matchList);
    	roundList.add(round);
	}
    
    @Test
   	public void findAllMatchesByRoundNoSuccessTest() 
   	{
       	Mockito.when(roundRepository.findByRoundNo(1)).thenReturn(this.roundList);

       	List<Round> rounds=roundServiceImpl.findAllMatchesByRoundNo(1);
       	Assertions.assertEquals(rounds.size(), roundList.size());
   	}
    
    @Test
	public void closeRoundSuccessTest() 
	{
    	roundServiceImpl.closeRound((long)1);
	}
}
