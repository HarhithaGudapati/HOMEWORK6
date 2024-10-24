package com.acs560.Sport_analyzer.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Embeddable
@Getter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TeamEntityId implements Serializable {
 
	private static final long serialVersionUID = 7252327203288421943L;
	 
	    private int leagueyear;
	    private String team;
	    private int companyId;
 
 
}
