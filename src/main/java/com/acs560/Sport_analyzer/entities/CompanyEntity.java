package com.acs560.Sport_analyzer.entities;

import java.util.List;

import com.acs560.Sport_analyzer.models.Company;


import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import com.acs560.Sport_analyzer.models.Company;
import com.acs560.Sport_analyzer.requests.CompanyRequest;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "companies ")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
/*public class CompanyEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	// Define the relationship with TeamEntity
    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
    private List<TeamEntity> teams;
    
 // Constructors
    public CompanyEntity(String name) {
        this.name = name;
    }

    public CompanyEntity(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
    
	@Column(unique=true)
	private String name;
	
	public CompanyEntity (CompanyRequest c) {
		this.name = c.getName();
	}
	
	public CompanyEntity(Company c) { 
		this(c.getId(), c.getName());
	}
} */

public class CompanyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String name;

    // Optional: Mapping if there’s a list of TeamEntities associated with the company
    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
    private List<TeamEntity> teams;
    
    public CompanyEntity(CompanyRequest request) {
        this.name = request.getName();
        // Initialize other fields as needed
    }

    public CompanyEntity(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

