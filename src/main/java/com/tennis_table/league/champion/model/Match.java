package com.tennis_table.league.champion.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="match")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","round"})
public class Match implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="match_id")
	private Long matchId;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Participant player1;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Participant player2;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="round")
	@JsonIgnore
	private Round round;
	
	private LocalDate dueDate;
	
	private String result;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Participant winner;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private League league;
}
