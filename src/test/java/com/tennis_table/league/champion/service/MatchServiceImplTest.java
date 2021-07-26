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
import com.tennis_table.league.champion.repository.IMatchesRepository;
import com.tennis_table.league.champion.service.impl.MatchesServiceImpl;

@ExtendWith(MockitoExtension.class)
public class MatchServiceImplTest {

	@InjectMocks
	private MatchesServiceImpl matchesServiceImpl;
	
	@Mock
	private IMatchesRepository matchesRepository;
	
	@Mock
	private IRoundsService roundsService;

	
	private Participant player1;
	private Participant player2;
	private Round round;
    private List<Participant> participantList =new ArrayList<>();
    
    private List<Match> matchList =new ArrayList<>();
    private Match match;
    
   
    @BeforeEach
	public void setup()
	{
    	round=new Round((long) 1, "Round 1", 1, RoundStatus.NEW,null);
    	match=new Match((long) 1, player1, player2, round, LocalDate.now(), "2-1,3-2", null, null);
    	
    	player1=new Participant((long) 1, "Muhammad", "m@mail.com", 1, "0123456789");
    	player2=new Participant((long) 2, "Ahmad", "a@mail.com", 2, "0123456798");
    	
    	participantList.add(player1);
    	participantList.add(player2);
    	matchList.add(match);
	}
    
    @Test
   	public void findAllMatchesSuccessTest() 
   	{
       	Mockito.when(matchesRepository.findAll()).thenReturn(this.matchList);

       	List<Match> matches=matchesServiceImpl.findAllMatches();
       	Assertions.assertEquals(matches.size(), matchList.size());
   	}
    
    @Test
	public void createMatchesSuccessTest() 
	{
    	matchesServiceImpl.createMatches(participantList, 1, 1, 1, null);
	}
}
