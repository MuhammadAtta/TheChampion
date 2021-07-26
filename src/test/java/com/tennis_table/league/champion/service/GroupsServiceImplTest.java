package com.tennis_table.league.champion.service;

import java.util.ArrayList;
import java.util.List;

import com.tennis_table.league.champion.model.Participant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.tennis_table.league.champion.repository.IGroupRepository;
import com.tennis_table.league.champion.service.impl.GroupsServiceImpl;

@ExtendWith(MockitoExtension.class)
public class GroupsServiceImplTest {

	@InjectMocks
	private GroupsServiceImpl groupsServiceImpl;
	
	@Mock
	private IGroupRepository groupRepository;
	
	@Mock
	private IParticipantsService participantsService;
	
	@Mock
	private IMatchesService matchesService;
	
	private Participant player1;
	private Participant player2;
	private List<Participant> participantList =new ArrayList<>();
   
    @BeforeEach
	public void setup()
	{
    	player1=new Participant((long) 1, "muhammad", "m@mail.com", 1, "0123456789");
    	player2=new Participant((long) 2, "Ahmad", "a@mail.com", 2, "0123456798");
    	
    	participantList.add(player1);
    	participantList.add(player2);
	}
    
    @Test
	public void createGroupsSuccessTest() 
	{
    	Mockito.when(participantsService.findAllParticipants()).thenReturn(participantList);
    	groupsServiceImpl.createGroups();
	}
}
