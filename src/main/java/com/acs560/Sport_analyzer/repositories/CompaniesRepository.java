package com.acs560.Sport_analyzer.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.acs560.Sport_analyzer.entities.CompanyEntity;

/*public interface CompaniesRepository extends CrudRepository<CompanyEntity, Integer> {

	CompanyEntity findByName(String name);
	
}*/

@Repository
public interface CompaniesRepository extends CrudRepository<CompanyEntity, Integer> {
    @Query("SELECT c FROM CompanyEntity c WHERE c.name = :name")
    CompanyEntity findByName(@Param("name") String name);
    
    @Query("SELECT c FROM CompanyEntity c LEFT JOIN FETCH c.teams")
    List<CompanyEntity> findAllWithTeams();
}
