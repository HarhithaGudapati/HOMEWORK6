package com.acs560.Sport_analyzer.services;


import java.util.List;
import java.util.Optional;

import com.acs560.Sport_analyzer.models.Team;
public interface TeamService {
	
	/**
	 * Get a team by name and year
	 * @param name - the name
	 * @param year - the year
	 * @return - the Team
	 */
	//Optional<Team> getTeam(String name, int year);
	
	/**
	 * Get the list of all teams
	 * @return - the list of teams
	 */
	List<Team> getTeams();
	
	/**
	 * Get the teams filtered by name
	 * @param name - the name
	 * @return - the list of teams filtered by name
	 */
	List<Team> getTeamsByName(String name);
	
	/**
	 * Get the teams filtered by name and year
	 * @param name - the name
	 * @param year - the year
	 * @return
	 */
	
	void addTeam(Team team);
	void deleteTeam(Team team);
	void updateTeam(Team team);

	List<Team> getTeamsByYear(int year);
	
	List<Team> getTeamsByYearAndRange(int year, int range);

	List<Team> getTeamsByNameAndYearAndRange(String name, int year, int range);

	List<Team> getTeamByNameAndYear(String name, int year);

	Optional<Team> getTeam(String name, int year);

	Object getTeamsByCompany(int id);

	Optional<Team> getTeam(int companyId, String name, int year);

	


	
}

