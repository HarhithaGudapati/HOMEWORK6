package com.acs560.Sport_analyzer.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acs560.Sport_analyzer.entities.CompanyEntity;
import com.acs560.Sport_analyzer.entities.TeamEntity;
import com.acs560.Sport_analyzer.models.Company;
import com.acs560.Sport_analyzer.models.Team;
import com.acs560.Sport_analyzer.repositories.CompaniesRepository;
import com.acs560.Sport_analyzer.repositories.TeamRepository;
import com.acs560.Sport_analyzer.requests.CompanyRequest;
import com.acs560.Sport_analyzer.services.CompaniesService;





/*@Service
public class CompaniesServiceImpl implements CompaniesService {
    private final CompaniesRepository companiesRepository;
    private final TeamRepository teamRepository;
    
    @Autowired
    public CompaniesServiceImpl(CompaniesRepository companiesRepository, TeamRepository teamRepository) {
        this.companiesRepository = companiesRepository;
        this.teamRepository = teamRepository;
    }
    
    @Override
    public List<Company> getCompanies() {
        List<CompanyEntity> companyEntities = StreamSupport
            .stream(companiesRepository.findAll().spliterator(), false)
            .collect(Collectors.toList());
            
        return companyEntities.stream()
            .map(ce -> {
                List<TeamEntity> teamEntities = teamRepository.findAllByIdCompanyId(ce.getId());
                List<Team> teams = teamEntities.stream()
                    .map(Team::new)
                    .collect(Collectors.toList());
                return new Company(ce.getId(), ce.getName());
            })
            .collect(Collectors.toList());
    }
    
    @Override
    public Optional<Company> getCompany(int id) {
        return companiesRepository.findById(id)
            .map(ce -> {
                List<TeamEntity> teamEntities = teamRepository.findAllByIdCompanyId(ce.getId());
                List<Team> teams = teamEntities.stream()
                    .map(Team::new)
                    .collect(Collectors.toList());
                return new Company(ce.getId(), ce.getName());
            });
    }
    
    @Override
    public Optional<Company> getCompanyByName(String name) {
        CompanyEntity ce = companiesRepository.findByName(name);
        if (ce != null) {
            List<TeamEntity> teamEntities = teamRepository.findAllByIdCompanyId(ce.getId());
            List<Team> teams = teamEntities.stream()
                .map(Team::new)
                .collect(Collectors.toList());
            return Optional.of(new Company(ce.getId(), ce.getName()));
        }
        return Optional.empty();
    }
    
    @Override
    public Company addCompany(CompanyRequest c) {
        CompanyEntity companyToAdd = new CompanyEntity(c);
        CompanyEntity savedEntity = companiesRepository.save(companyToAdd);
        return new Company(savedEntity.getId(), savedEntity.getName());
    }
    
    @Override
    public Company updateCompany(int id, CompanyRequest c) {
        if (companiesRepository.existsById(id)) {
            CompanyEntity updated = companiesRepository.save(new CompanyEntity(id, c.getName()));
            List<TeamEntity> teamEntities = teamRepository.findAllByIdCompanyId(updated.getId());
            List<Team> teams = teamEntities.stream()
                .map(Team::new)
                .collect(Collectors.toList());
            return new Company(updated.getId(), updated.getName());
        }
        return null;
    }
    @Override
    public boolean deleteCompany(int id) {
        if (companiesRepository.existsById(id)) {
            companiesRepository.deleteById(id);
            return true;
        }
        return false;
    }

	@Override
	public boolean isPresent() {
		// TODO Auto-generated method stub
		return false;
	}
} */

@Service
public class CompaniesServiceImpl implements CompaniesService {
    private final CompaniesRepository companiesRepository;
    private final TeamRepository teamRepository;

    @Autowired
    public CompaniesServiceImpl(CompaniesRepository companiesRepository, TeamRepository teamRepository) {
        this.companiesRepository = companiesRepository;
        this.teamRepository = teamRepository;
    }

    @Override
    public List<Company> getCompanies() {
        return StreamSupport
            .stream(companiesRepository.findAll().spliterator(), false)
            .map(ce -> {
                List<Team> teams = teamRepository.findAllByIdCompanyId(ce.getId())
                    .stream()
                    .map(Team::new)
                    .collect(Collectors.toList());
                return new Company(ce.getId(), ce.getName());
            })
            .collect(Collectors.toList());
    }

    @Override
    public Optional<Company> getCompany(int id) {
        return companiesRepository.findById(id)
            .map(ce -> new Company(ce.getId(), ce.getName()));
    }

    @Override
    public Optional<Company> getCompanyByName(String name) {
        CompanyEntity ce = companiesRepository.findByName(name);
        return ce != null 
            ? Optional.of(new Company(ce.getId(), ce.getName())) 
            : Optional.empty();
    }

    @Override
    public Company addCompany(CompanyRequest c) {
        CompanyEntity companyToAdd = new CompanyEntity(c);
        CompanyEntity savedEntity = companiesRepository.save(companyToAdd);
        return new Company(savedEntity.getId(), savedEntity.getName());
    }

    @Override
    public Company updateCompany(int id, CompanyRequest c) {
        return companiesRepository.findById(id)
            .map(existingCompany -> {
                CompanyEntity updatedEntity = new CompanyEntity(id, c.getName());
                companiesRepository.save(updatedEntity);
                return new Company(id, c.getName());
            })
            .orElse(null);
    }

    @Override
    public boolean deleteCompany(int id) {
        if (companiesRepository.existsById(id)) {
            companiesRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean isPresent() {
        return companiesRepository.count() > 0;
    }
}

