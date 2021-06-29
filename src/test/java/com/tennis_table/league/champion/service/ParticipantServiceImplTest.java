package com.tennis_table.league.champion.service;

import java.util.ArrayList;
import java.util.List;

import com.tennis_table.league.champion.model.Participant;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.tennis_table.league.champion.repository.IParticipantsRepository;
import com.tennis_table.league.champion.service.impl.ParticipantsServiceImpl;

@ExtendWith(MockitoExtension.class)
public class ParticipantServiceImplTest {

	@InjectMocks
	private ParticipantsServiceImpl participantsServiceImpl;
	
	@Mock
	private IParticipantsRepository participantsRepository;
	
	private Participant participant;
    private List<Participant> participantList =new ArrayList<>();
    
   
    @BeforeEach
	public void setup()
	{
    	participant =new Participant((long) 1, "Muhammad", "muhammad.abdelmageed@mail.com", 1, "+919754258264");
    	participantList.add(participant);
	}
    
    @Test
	public void saveParticipantsSuccessTest() 
	{
    	participantsServiceImpl.createParticipants(participant);
	}
    
    @Test
   	public void findAllParticipantsSuccessTest() 
   	{
       	Mockito.when(participantsRepository.findAll()).thenReturn(this.participantList);

       	List<Participant> participant1 =participantsServiceImpl.findAllParticipants();
       	Assertions.assertEquals(participant1.size(), participantList.size());
   	}
}
