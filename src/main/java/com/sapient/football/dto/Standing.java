package com.sapient.football.dto;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class Standing implements Serializable {

    private String country_id;
    private String country_name;
    private String league_id;
    private String league_name;
    private String team_id;
    private String team_name;
    private String overall_league_position;

}
