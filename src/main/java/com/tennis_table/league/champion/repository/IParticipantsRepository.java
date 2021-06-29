package com.tennis_table.league.champion.repository;

import com.tennis_table.league.champion.model.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//import org.springframework.data.repository.CrudRepository;



// This will be AUTO IMPLEMENTED by Spring into a Bean called participantRepository
// CRUD refers Create, Read, Update, Delete

@Repository
public interface IParticipantsRepository extends JpaRepository<Participant, Long>{
   // public interface IParticipantsRepository extends CrudRepository<Participant, Long>{



// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete


    }
