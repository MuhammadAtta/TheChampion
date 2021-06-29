package com.tennis_table.league.champion.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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

import com.tennis_table.league.champion.service.IMatchesService;

@WebMvcTest(controllers = MatchController.class)
@ActiveProfiles("test")
public class MatchControllerTest {

	@Autowired
    private MockMvc mockMvc;

    @MockBean
    private IMatchesService matchesService;
    
    
    @Test
    @Tag("testFindAllMatchesSuccess")
    void testFindAllMatchesSuccess() throws Exception {

    	mockMvc.perform(get("/api/match").contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
    
}
