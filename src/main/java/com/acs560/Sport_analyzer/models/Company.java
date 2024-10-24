package com.acs560.Sport_analyzer.models;

import com.acs560.Sport_analyzer.entities.CompanyEntity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Company implements Comparable<Company> {

	private int id;
	private String name;
	
	public Company(CompanyEntity ce) {
		this(ce.getId(), ce.getName());
	}

	@Override
	public int compareTo(Company o) {
		return name.compareTo(o.name);
	}
}
