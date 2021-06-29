package com.tennis_table.league.champion.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="group")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Group implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)

	@Column(name="group_id")
	private Long groupId;
	
	private String name;
	
	@ManyToMany(targetEntity= Participant.class, fetch=FetchType.LAZY)
	@JoinTable(name="group_participant",joinColumns=@JoinColumn(name="group_id"),inverseJoinColumns=@JoinColumn(name="participant_id"))
	private List<Participant> groupParticipant;
}
