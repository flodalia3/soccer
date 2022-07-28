package it.accenture.soccer.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RefereeDTO {
    private long id;
    private String name;
    private String surname;
    private LocalDate dob;
    private LocalDate workSince;
    private String cityName;
}
