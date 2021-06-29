package com.tennis_table.league.champion.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import com.tennis_table.league.champion.service.IGroupsService;

@WebMvcTest(controllers = GroupsController.class)
@ActiveProfiles("test")
public class GroupControllerTest {

	@Autowired
    private MockMvc mockMvc;

    @MockBean
    private IGroupsService groupsService;
    
    
    @Test
    @Tag("testCreateGroupSuccess")
    void testCreateGroupSuccess() throws Exception {

    	mockMvc.perform(post("/api/groups").contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
    
}
