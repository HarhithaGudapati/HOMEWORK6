package com.acs560.Sport_analyzer.entities;
import com.acs560.Sport_analyzer.models.Team;


import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity()
@Table(name = "sportsdata")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TeamEntity {
    @EmbeddedId
    private TeamEntityId id;
    @ManyToOne
    @MapsId("companyId")
    private CompanyEntity company;
  
    private String league;
    private int wins;
    private int losses;
    private int points;
    
  /*  @ManyToOne
    @JoinColumn(name = "league_name", referencedColumnName = "name")
    private LeagueEntity league;
 */
    public TeamEntityId getId() {
        return id;
    }
    
    
 /*   public TeamEntity(TeamEntityId id, int wins, int losses, int points) {
        this.id = id;
        this.wins = wins;
        this.losses = losses;
        this.points = points;
    } */
    
    public TeamEntity(Team team) {
    //	this(new TeamEntityId(team.getYear(), team.getName(), team.getLeague()), team.getWins(), team.getLosses(), team.getPoints());
    	this.id = new TeamEntityId(team.getYear(), team.getCompany().getId(),new CompanyEntity(team.getCompany()) );
    	this.league = team.getLeague();
    	this.wins= team.getWins();
    	this.losses = team.getLosses();
    	this.points = team.getPoints();
    	
    }
    
      
    
}

