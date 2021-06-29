package com.tennis_table.league.champion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tennis_table.league.champion.model.League;

public interface ILeagueRepository extends JpaRepository<League, Long>{

}
