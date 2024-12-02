package com.acs560.Sport_analyzer.services.impl;

import java.util.Comparator;


import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acs560.Sport_analyzer.entities.TeamEntity;
import com.acs560.Sport_analyzer.entities.TeamEntityId;
import com.acs560.Sport_analyzer.models.Team;
import com.acs560.Sport_analyzer.repositories.TeamRepository;
import com.acs560.Sport_analyzer.services.TeamService;


/**
 * The teams service implementation
 */
@Service
public class TeamServiceImpl implements TeamService {
	
	@Autowired
	TeamRepository tr;
	
	@Autowired
	public TeamServiceImpl(TeamRepository tr) {
		this.tr = tr;
	}
	
	@Override
	public Optional<Team> getTeam(int companyId ,String name, int year) {
		TeamEntityId id = new TeamEntityId(name,companyId, year );
		var te = tr.findById(id);
		//Optional<Team> result = te.isPresent() ? Optional.of(new Team(te.get())) : Optional.empty(); 
		
		//return result;
		return te.map(Team::new);
	}

	
	private boolean exists(TeamEntity te) {
	    TeamEntityId teamId = te.getId();  // Ensure te.getId() returns a TeamEntityId
	    return tr.existsById(teamId);
	}
	
	@Override
	public List<Team> getTeams(){
		var teamEntities = ((List<TeamEntity>) tr.findAll());
		return from(teamEntities);
	}
	
	@Override
	public List<Team> getTeamByNameAndYear (String name, int year) {
		var teamEntities = tr.findAllByIdLeagueyearAndIdCompanyId(year, name);
		return from(teamEntities);
	}
	
	@Override
	public List<Team> getTeamsByYear(int year) {
		var teamEntities = tr.findAllByIdLeagueyear(year);
		return from(teamEntities);
	}
	
	@Override
	public List<Team> getTeamsByYearAndRange(int year, int range) {
		var years = getRange(year, range);
		var teamEntities = tr.findAllByIdLeagueyearIn(years);
		
		return from(teamEntities);
	}
	
	@Override
	public List<Team> getTeamsByNameAndYearAndRange(String name, int year, int range) {
		var years = getRange(year, range);
		var teamEntities = tr.findAllByIdNameAndIdLeagueyearIn(name, years);
		
		return from(teamEntities);
	}



	private static Set<Integer> getRange(int year, int range) {
		int lowerRange = year - range;
		int upperRange = year + range;
		
		Set<Integer> years = new HashSet<>();
		
		for (int i = lowerRange; i <= upperRange; i++) {
			years.add(i);
		}
		
		return years;
	}
	
	private List<Team> from(List<TeamEntity> teamEntities){
		var teams = teamEntities.stream()
				.map(te -> new Team(te))
				.collect(Collectors.toList());

		if (teams.isEmpty()) {
			throw new NoSuchElementException();
		}
		
		teams.sort(Comparator.comparing(Team::getYear)
				.thenComparing(Team::getName)
				.thenComparing(Team::getLeague));
		return teams;
	}
	
	@Override
	public void addTeam(Team team) {
TeamEntity teamToAdd = new TeamEntity(team);
TeamEntityId teamId = teamToAdd.getId(); 
		
		/*if (exists(teamToAdd)) {
			throw new IllegalArgumentException("Team already exists");
		}
		
		tr.save(teamToAdd); */
 if (tr.existsById(teamId)) {
    throw new IllegalArgumentException("Team already exists");
}

tr.save(teamToAdd);
		
	}

	@Override
	public void deleteTeam(Team team) {
TeamEntity teamToDelete = new TeamEntity();
		
		if (!exists(teamToDelete)) {
			throw new NoSuchElementException("Team does not exist");
		}
		
		tr.delete(new TeamEntity(team));
		
	}

	@Override
	public void updateTeam(Team team) {
TeamEntity teamToUpdate = new TeamEntity(team);
		
		if (!exists(teamToUpdate)) {
			throw new NoSuchElementException("Team does not exist");
		}
		
		tr.save(new TeamEntity(team));
		
	}

	@Override
	public List<Team> getTeamsByCompany(int companyId) {
	
		var teamEntities = tr.findAllByIdCompanyId(companyId);
		return from(teamEntities);
	}

	@Override
	public Optional<Team> getTeam(String name, int year) {
		
		return Optional.empty();
	}

	@Override
	public List<Team> getTeamsByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}


	
}



