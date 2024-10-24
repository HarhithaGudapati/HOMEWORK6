package com.acs560.Sport_analyzer.repositories;

import org.springframework.data.repository.CrudRepository;

import com.acs560.Sport_analyzer.entities.CompanyEntity;

public interface CompaniesRepository extends CrudRepository<CompanyEntity, Integer> {

	CompanyEntity findByName(String name);
	
}
