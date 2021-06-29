package com.tennis_table.league.champion.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tennis_table.league.champion.model.Group;
import com.tennis_table.league.champion.service.IGroupsService;

@RestController
@RequestMapping(path="/api/groups",produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
public class GroupsController {

	
	private Logger logger=LoggerFactory.getLogger(GroupsController.class);

	@Autowired
	private IGroupsService groupsService;

	/**
	 * Group randomly participants into (n) groups
	 * @param participants
	 * @return
	 */
	@PostMapping
	public ResponseEntity<List<Group>> createGroups()
	{
		logger.info("@method createGroups");
		try {
			return ResponseEntity.ok(groupsService.createGroups());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		} 
	}
	
	
}
