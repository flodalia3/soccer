package it.accenture.soccer.model;

import it.accenture.soccer.model.abstractions.WithId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Stadium implements WithId<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    private String name;
    private int capacity;
    @Column(name = "EXIST_SINCE")
    private Date existSince;
    @ManyToOne
    @JoinColumn(name="CITY_ID", referencedColumnName = "ID", nullable=false)
    private City city;

    @OneToMany(mappedBy = "stadium")
    private Set<Match> matches;

    public int getNumMatchesPlayed(){
        int gamesPlayed = 0;
        for (Match m: matches){
            if (m.getGameDate().isBefore(LocalDate.now()) || m.getGameDate().isEqual(LocalDate.now()))
                gamesPlayed++;
        }
        return gamesPlayed;
    }

    public int getNumFutureMatches(){
        int futureGames = 0;
        for (Match m: matches){
            if (m.getGameDate().isAfter(LocalDate.now()))
                futureGames++;
        }
        return futureGames;
    }
}
