package com.tennis_table.league.champion.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tennis_table.league.champion.model.Participant;
import com.tennis_table.league.champion.service.IParticipantsService;
import com.tennis_table.league.champion.utils.MessageUtils;

@WebMvcTest(controllers = ParticipantsController.class)
@ActiveProfiles("test")
public class ParticipantControllerTest {

	@Autowired
    private MockMvc mockMvc;

    @MockBean
    private IParticipantsService participantsService;
    
    @Autowired
	private ObjectMapper objectMapper;
	
    
    private Participant participant;
    private List<Participant> participantList =new ArrayList<>();
    
   
    @BeforeEach
	public void setup()
	{
    	participant =new Participant((long) 1, "Muhammad", "m@mail.com", 1, "0123456789");
    	participantList.add(participant);
	}
	
	/**
	 * Test Create Participant Success
	 *
	 * @throws Exception the exception
	 */
	@Test
    @Tag("testCreateParticipantSuccess")
    void testCreateParticipantSuccess() throws Exception {

    	Mockito.when(participantsService.createParticipants(this.participant)).thenReturn(MessageUtils.PARTICIPANTS_CREATED_SUCCESSFULLY);
    	mockMvc.perform(post("/api/participant").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(this.participant))
                .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(content().string(MessageUtils.PARTICIPANTS_CREATED_SUCCESSFULLY));
    }

}
