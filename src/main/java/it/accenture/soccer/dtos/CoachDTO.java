package it.accenture.soccer.dtos;

import it.accenture.soccer.model.City;
import it.accenture.soccer.model.Team;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.util.Date;

@AllArgsConstructor
@Getter @Setter
@NoArgsConstructor
public class CoachDTO {
    private Long id;
    private String name;
    private String surname;
    private Team team;
    private long teamId;
    private String teamName;
    private long birthCityId;
    private String birthCityName;
}
