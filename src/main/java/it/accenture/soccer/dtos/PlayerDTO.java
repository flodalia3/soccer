package it.accenture.soccer.dtos;

import it.accenture.soccer.model.City;
import it.accenture.soccer.model.Team;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class PlayerDTO {
    private Long id;
    private String name;
    private String surname;
    private String dob;
    private int jersey;
    private long teamId;
    private String teamName;
    private long roleId;
    private String roleName;
    private String birthCity;
    private int numGoals;
    private int numAssists;
}
