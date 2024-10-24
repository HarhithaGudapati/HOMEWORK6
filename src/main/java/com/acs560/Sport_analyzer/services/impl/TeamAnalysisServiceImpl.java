package com.acs560.Sport_analyzer.services.impl;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acs560.Sport_analyzer.models.Team;
import com.acs560.Sport_analyzer.services.TeamAnalysisService;
import com.acs560.Sport_analyzer.services.TeamService;

@Service
public  class TeamAnalysisServiceImpl implements TeamAnalysisService {

	@Autowired
	TeamService ts;
	
	@Override
	public double calculateAverageWinsForYear(int year) {
		List<Team> teams = ts.getTeamsByYear(year);
		return getAverageWins(teams);
	}
	
	@Override
	public double calculateAverageWinsForYearAndRange(int year, int Range) {		
		List<Team> teams = ts.getTeamsByYearAndRange(year, Range);
		return getAverageWins(teams);
	}
	

	@Override
	public double calculateMeanWins() {
		var teams = this.ts.getTeams();
		return getAverageWins(teams);
	}

	@Override
	public double calculateMedianWins() {	
		List<Team> teams = ts.getTeams();
		return getMedianWins(teams);
	}
		
	@Override
	public int calculateModeWins() {	
		List<Team> teams = ts.getTeams();
		return getModeWins(teams);
	}
		
	private double getAverageWins(List<Team> teams) {
		double average = teams
				.stream()
				.mapToDouble(Team::getWins)
				.average()
				.orElseThrow();
		return average;
	}

	private double getMedianWins(List<Team> teams) {
		double median = teams
				.stream()
				.mapToDouble(Team::getWins)
				.sorted()
				.skip(teams.size() / 2)
				.findFirst()
				.orElseThrow();
		return median;
	}

	private int getModeWins(List<Team> teams) {
		int mode = teams
				.stream()
				.mapToInt(Team::getWins)
				.boxed()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				.entrySet()
				.stream()
				.max(Comparator.comparing(Map.Entry::getValue))
				.map(Map.Entry::getKey)
				.orElseThrow();
		return mode;
	}


} 









