package com.acs560.Sport_analyzer.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


/*@Embeddable
@Getter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TeamEntityId implements Serializable {
 
	
	public static String getCompanyId;
	private static final long serialVersionUID = 7252327203288421943L;
	private String name =  ""; 
	    private int leagueyear = 0;
	    private int companyId = 0; 
} */

@Embeddable
@Getter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TeamEntityId implements Serializable {
    private static final long serialVersionUID = 7252327203288421943L;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "league_year")
    private int leagueyear;
    
    @Column(name = "company_id")
    private int companyId;
}
