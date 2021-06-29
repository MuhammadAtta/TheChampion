package com.tennis_table.league.champion.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="round")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Round implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long roundId;
	
	private String name;
	
	private int roundNo;
	
	
	@Enumerated(EnumType.STRING)
    private RoundStatus roundStatus;
	
	public enum RoundStatus {NEW,IN_PROGRESS,CLOSE}
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="round")
	private List<Match> matches;
}
