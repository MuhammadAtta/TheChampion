package com.tennis_table.league.champion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tennis_table.league.champion.model.Round;

@Repository
public interface IRoundRepository extends JpaRepository<Round, Long>{

	List<Round> findByRoundNo(int roundNo);
}
