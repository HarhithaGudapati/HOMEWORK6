package com.acs560.Sport_analyzer.repositories;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.acs560.Sport_analyzer.entities.TeamEntity;
import com.acs560.Sport_analyzer.entities.TeamEntityId;

public interface TeamRepository extends CrudRepository<TeamEntity, TeamEntityId> {

	List<TeamEntity> findAllByIdCompanyId(int companyId);

	List<TeamEntity> findAllByIdLeagueyear(int year);
	
	List<TeamEntity> findAllByIdLeagueyearIn(Set<Integer> years);
	
	List<TeamEntity> findAllByIdNameAndIdLeagueyearIn(String name, Set<Integer> years);
	@Query("SELECT t FROM TeamEntity t WHERE t.id.leagueyear = :year AND t.id.companyId = :companyId")
	List<TeamEntity> findAllByIdLeagueyearAndIdCompanyId(@Param("year") int leagueyear, @Param("companyId") String name);

	@Query(value = """
		SELECT AVG(points) FROM team WHERE name = ?1
			""", nativeQuery=true)
	Double calculateAveragePoints(String name);
	
	@Query(value = """
			SELECT AVG(points) FROM team WHERE leagueyear = ?1 AND name = ?2
			""", nativeQuery=true)
	Double calculateAveragePoints(int leagueyear, String name);

	@Query(value = """
			SELECT AVG(points) FROM team WHERE leagueyear = ?1
			""", nativeQuery=true)
	Double calculateAveragePoints(int leagueyear);
	
	@Query(value = """
			SELECT AVG(points) FROM team WHERE leagueyear IN ?1
			""", nativeQuery=true)
	Double calculateAveragePoints(Set<Integer> leagueyears);
	
	@Query(value = """
			SELECT AVG(points) FROM team WHERE leagueyear in ?1 AND name = ?2
			""", nativeQuery=true)
	Double calculateAveragePoints(Set<Integer> leagueyears, String name);
	
	List<TeamEntity> findAllByIdName(String name);

}  















