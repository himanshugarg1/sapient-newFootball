package com.sapient.football.api;

import com.sapient.football.dto.Standing;

public interface FootballFacade {

    Standing getStanding(final String country, final String league, final String team);

}
