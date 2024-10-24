package com.acs560.Sport_analyzer.controllers;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acs560.Sport_analyzer.models.Company;
import com.acs560.Sport_analyzer.models.Team;
import com.acs560.Sport_analyzer.requests.CompanyRequest;
import com.acs560.Sport_analyzer.services.CompaniesService;
import com.acs560.Sport_analyzer.services.TeamService;

import jakarta.validation.Valid;

@RestController()
@RequestMapping("/api/v1/companies")
public class CompaniesController {

	private CompaniesService cs;
	
	@Autowired
	public CompaniesController(CompaniesService cs) {
		this.cs = cs;
	}
	
	@GetMapping
	public ResponseEntity<List<Company>> getCompanies(){
		return ResponseEntity.ok(cs.getCompanies());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<List<Company>> getCompany(@PathVariable int id){
		var company = cs;
		
		return company.isPresent() ? 
				ResponseEntity.ok(company.getCompanies()) : ResponseEntity.notFound().build();
	}
	
	
	@PostMapping
	public ResponseEntity<Company> addCompany(@Valid @RequestBody CompanyRequest c){
		var addedCompany = cs.addCompany(c);
		
		return ResponseEntity.created(null).body(addedCompany);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Company> addCompany(@PathVariable int id,
			@Valid @RequestBody CompanyRequest c){

			cs.updateCompany(id, c);
		
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Company> deleteCompany(@PathVariable int id){
		cs.deleteCompany(id);
		
		return ResponseEntity.ok().build();
	}
	
}

