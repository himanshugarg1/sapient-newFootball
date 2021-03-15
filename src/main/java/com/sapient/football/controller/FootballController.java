package com.sapient.football.controller;

import com.sapient.football.api.FootballFacade;
import com.sapient.football.dto.ResponseDTO;
import com.sapient.football.dto.Standing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class FootballController {

    private final FootballFacade facade;

    @Autowired
    public FootballController(FootballFacade facade) {
        this.facade = facade;
    }

    @GetMapping("team-standings")
    public ResponseEntity<Standing> fetchTeamStandings(
            @RequestParam final String country,
            @RequestParam final String league,
            @RequestParam final String team
    ) {
        final Standing standing = facade.getStanding(country, league, team);
        if(standing == null){
            ResponseEntity.unprocessableEntity().body("Team Standing not found for given data");
        }
        return ResponseEntity.ok(standing);
    }

}
