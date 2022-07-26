package it.accenture.soccer.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TeamDTO {
    private Long id;
    private String name;
    private String logo;
    private String motto;
    private int titles;
    private String cityName;
    //MI INTERESSA INSERIRE NEL DTO I SET DEI MATCH (HOME E AWAY) E DEI PLAYERS?
}
