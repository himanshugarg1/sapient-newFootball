package com.sapient.football.api;

import com.sapient.football.api.client.APIFootball;
import com.sapient.football.dto.Country;
import com.sapient.football.dto.League;
import com.sapient.football.dto.Standing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class FootballFacadeImpl implements FootballFacade {

    private final APIFootball service;

    @Autowired
    public FootballFacadeImpl(APIFootball service) {
        this.service = service;
    }

    @Override
    public Standing getStanding(String country, String league, String team) {

        final List<Country> countries = service.getCountries();

        final var countryObj = countries.stream().filter(x -> x.getCountry_name().equalsIgnoreCase(country))
                .findFirst();

        if(!countryObj.isPresent()) {
            return null;
        }

        final List<League> leagues = service.getLeagues(countryObj.get().getCountry_id());
        final Optional<League> LeagueObj = leagues.stream()
                .filter(x -> x.getLeague_name().equalsIgnoreCase(league))
                .findFirst();
        if(!LeagueObj.isPresent()) {
            return null;
        }

        final List<Standing> standings = service.getStandings(LeagueObj.get().getLeague_id());
        final Optional<Standing> first = standings.stream().filter(x -> x.getTeam_name().equalsIgnoreCase(team)).findFirst();
        if(!first.isPresent()) {
            return null;
        }
        return first.get();
    }
}
