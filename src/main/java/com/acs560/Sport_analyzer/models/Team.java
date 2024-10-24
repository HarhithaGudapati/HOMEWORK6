package com.acs560.Sport_analyzer.models;

import java.util.Comparator;
import java.util.Objects;

import com.acs560.Sport_analyzer.entities.TeamEntity;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


/**
 * Data encapsulation class of the team data.
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Team implements Comparable<Team> {

    @NotNull(message="Year is required")
    @Min(value=1000, message="Year must be 4 digits")
    @Max(value=9999, message="Year must be 4 digits")
    private Integer year;

    @NotNull(message="Name is required")
    private String name;

    @NotNull(message="League is required")
    private String league;

    @NotNull(message="Wins are required")
    @Min(value=0, message="Wins must be non-negative")
    private Integer wins;

    @NotNull(message="Losses are required")
    @Min(value=0, message="Losses must be non-negative")
    private Integer losses;

    @NotNull(message="Points are required")
    @Min(value=0, message="Points must be non-negative")
    private Integer points;

    @Override
    public int hashCode() {
        return Objects.hash(year, name, league);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Team other = (Team) obj;
        return Objects.equals(year, other.year) && Objects.equals(name, other.name) &&
                Objects.equals(league, other.league);
    }

    public Team(String name, int year, String league) {
        this.name = name;
        this.year = year;
        this.league = league;
    }

    public Team(TeamEntity te) {
        this(te.getId().getLeagueyear(),
                te.getId().getTeam(),
                te.getLeague(),
                te.getWins(),
                te.getLosses(),
                te.getPoints());
    }

    @Override
    public int compareTo(Team o) {
        return Comparator.comparing(Team::getYear)
                .thenComparing(Team::getName)
                .thenComparing(Team::getLeague)
                .compare(this, o);
    }

	public TeamEntity getCompany() {
		// TODO Auto-generated method stub
		return null;
	}
}
