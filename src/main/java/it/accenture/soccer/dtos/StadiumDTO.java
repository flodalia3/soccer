package it.accenture.soccer.dtos;

import it.accenture.soccer.model.City;
import it.accenture.soccer.model.Match;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.JoinColumn;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StadiumDTO {
    private Long id;
    private String name;
    private int capacity;
    private LocalDate existSince;
    private City city;
    private int pastMatches;
    private int upcomingMatches;
}
