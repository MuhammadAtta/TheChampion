package com.tennis_table.league.champion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tennis_table.league.champion.model.Group;

@Repository
public interface IGroupRepository extends JpaRepository<Group, Long>{

}
