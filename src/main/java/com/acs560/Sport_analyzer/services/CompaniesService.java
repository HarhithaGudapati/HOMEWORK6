package com.acs560.Sport_analyzer.services;

import java.util.List;

import java.util.Optional;

import com.acs560.Sport_analyzer.models.Company;
import com.acs560.Sport_analyzer.requests.CompanyRequest;

import jakarta.validation.Valid;

public interface CompaniesService {


	List<Company> getCompanies();
	
	Optional<Company> getCompany(int id);
	
	Company addCompany(@Valid CompanyRequest c);
	Company updateCompany(int id, CompanyRequest c);
	boolean deleteCompany(int id);

	boolean isPresent();

	Object get();
	
	
}