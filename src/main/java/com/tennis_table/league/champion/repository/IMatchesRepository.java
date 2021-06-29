package com.tennis_table.league.champion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tennis_table.league.champion.model.Match;

@Repository
public interface IMatchesRepository extends JpaRepository<Match, Long>{
	
}
