package com.acs560.Sport_analyzer.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acs560.Sport_analyzer.models.Team;
import com.acs560.Sport_analyzer.services.TeamService;
import lombok.NoArgsConstructor;


@RestController()
@RequestMapping("/api/v1/teams")
@NoArgsConstructor
public class TeamController {
    @Autowired
    private TeamService teamService;
    
    @Autowired
	public TeamController(TeamService teamService) {
		this.teamService = teamService;
	}

    /**
     * Get all teams
     * @return - the list of @Team
     */
    @GetMapping
    public ResponseEntity<List<Team>> getTeams() {
        return ResponseEntity.ok(teamService.getTeams());
    }

    /**
     * Get a team
     * @param name - name of the team
     * @return - the @Team
     */
    @GetMapping("/name/{name}")
    public ResponseEntity<Team> getTeam(@PathVariable String name) {
        Optional<Team> team = teamService.getTeam(name, 0);
        ResponseEntity<Team> response = team.isPresent() ? ResponseEntity.ok(team.get()) : ResponseEntity.notFound().build();
        return response;
    }

    /**
     * Get teams filtered by year
     * @param year - the year
     * @return - list of all teams filtered by year
     */
    @GetMapping("/year/{year}")
    public ResponseEntity<Object> getTeams(@PathVariable int year) {
        return ResponseEntity.ok(teamService.getTeamsByYear(year));
    }

    /**
     * Get teams filtered by league
     * @param league - the league
     * @return - list of all teams filtered by league
     */
  /*  @GetMapping("/league/{league}")
    public ResponseEntity<Object> getTeams(@PathVariable String league) {
        return ResponseEntity.ok(teamService.getTeams(league));
    } */

   /* @GetMapping("/year/{year}/league/{league}")
    public ResponseEntity<Object> getTeams(@PathVariable int year, @PathVariable String league) {
        return ResponseEntity.ok(teamService.getTeams(league, year));
    } */

    @GetMapping("/company/{id}")
	public ResponseEntity<Object> getBillsByCompany(@PathVariable int id){
		return ResponseEntity.ok(teamService.getTeamsByCompany(id));
	}
    @PostMapping()
    public ResponseEntity<Team> add(@RequestBody Team team) {
        teamService.addTeam(team);
        return ResponseEntity.created(null).build();
    }

    @PutMapping()
    public ResponseEntity<Team> update(@RequestBody Team team) {
        teamService.updateTeam(team);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping()
    public ResponseEntity<Team> delete(@RequestBody Team team) {
        teamService.deleteTeam(team);
        return ResponseEntity.ok().build();
    }
}