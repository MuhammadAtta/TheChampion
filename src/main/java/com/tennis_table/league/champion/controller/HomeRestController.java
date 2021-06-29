package com.tennis_table.league.champion.controller;

import com.tennis_table.league.champion.service.impl.GroupsServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Muhammad Atta
 *
 */

@RestController
@RequestMapping(value = "/")
public class HomeRestController {
	private Logger logger= LoggerFactory.getLogger(HomeRestController.class);

	@GetMapping
	public String sayHello() {
		logger.info("@method sayHello");

		return "Welcome to the Tennis Table Champion Application. API endpoint.";
	}
}
