package com.sapient.football.api.client;

import com.sapient.football.dto.Country;
import com.sapient.football.dto.League;
import com.sapient.football.dto.Standing;
import com.sapient.football.util.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class APIFootball {

    private final RestTemplate restTemplate;

    @Autowired
    public APIFootball(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Standing> getStandings(String league_id) {
        final String uri = "https://apiv2.apifootball.com/?action=get_standings&league_id="
                + league_id
                + "&APIkey=" + AppConstants.API_KEY;
        ResponseEntity<List<Standing>> exchange = restTemplate.exchange(uri,
                HttpMethod.GET, null, new ParameterizedTypeReference<List<Standing>>() { });
        return exchange.getBody();
    }

    public List<Country> getCountries() {
        String uri = "https://apiv2.apifootball.com/?action=get_countries"
                + "&APIkey=" + AppConstants.API_KEY;
        ResponseEntity<List<Country>> exchange = restTemplate.exchange(uri,
                HttpMethod.GET, null, new ParameterizedTypeReference<List<Country>>() { });
        return exchange.getBody();
    }

    public List<League> getLeagues(String countryId) {
        String uri = "https://apiv2.apifootball.com/?action=get_leagues&country_id="
                + countryId
                + "&APIkey=" + AppConstants.API_KEY;
        ResponseEntity<List<League>> exchange = restTemplate.exchange(uri,
                HttpMethod.GET, null, new ParameterizedTypeReference<List<League>>() { });
        return exchange.getBody();
    }

}
