package com.sapient.football.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class League {
    private String country_id;
    private String country_name;
    private String league_id;
    private String league_name;
}
