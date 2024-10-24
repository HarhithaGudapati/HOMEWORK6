package com.acs560.Sport_analyzer.repositories;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.acs560.Sport_analyzer.entities.TeamEntity;
import com.acs560.Sport_analyzer.entities.TeamEntityId;

public interface TeamRepository extends CrudRepository<TeamEntity, TeamEntityId> {

	List<TeamEntity> findAllByIdCompanyId(int id);
	List<TeamEntity> findAllByIdTeam(String name);
	
	List<TeamEntity> findAllByIdLeagueyearAndIdTeam(int year, String name);

	List<TeamEntity> findAllByIdLeagueyear(int year);
	
	List<TeamEntity> findAllByIdLeagueyearIn(Set<Integer> years);
	
	List<TeamEntity> findAllByIdTeamAndIdLeagueyearIn(String name, Set<Integer> years);
	
	@Query(value = """
		SELECT AVG(points) FROM sports_data WHERE name = ?1
			""", nativeQuery=true)
	Double calculateAveragePoints(String name);
	
	@Query(value = """
			SELECT AVG(points) FROM sports_data WHERE year = ?1 AND name = ?2
			""", nativeQuery=true)
	Double calculateAveragePoints(int year, String name);

	@Query(value = """
			SELECT AVG(points) FROM sports_data WHERE year = ?1
			""", nativeQuery=true)
	Double calculateAveragePoints(int year);
	
	@Query(value = """
			SELECT AVG(points) FROM sports_data WHERE year in ?1
			""", nativeQuery=true)
	Double calculateAveragePoints(Set<Integer> years);
	
	@Query(value = """
			SELECT AVG(points) FROM sports_data WHERE year in ?1 AND name = ?2
			""", nativeQuery=true)
	Double calculateAveragePoints(Set<Integer> years, String name);
}














