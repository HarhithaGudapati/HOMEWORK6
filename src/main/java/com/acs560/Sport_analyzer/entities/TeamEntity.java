package com.acs560.Sport_analyzer.entities;
import com.acs560.Sport_analyzer.models.Team;


import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@Table(name = "team")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TeamEntity {
    @EmbeddedId
    private TeamEntityId id;
    
    private String league;
    private int wins;
    private int losses;
    private int points;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", insertable = false, updatable = false)
    private CompanyEntity company;
    
    public TeamEntity(Team team) {
        this.id = new TeamEntityId(
            team.getName(),
            team.getYear(),
            team.getCompany().getId()
        );
        this.league = team.getLeague();
        this.wins = team.getWins();
        this.losses = team.getLosses();
        this.points = team.getPoints();
    }
} 



