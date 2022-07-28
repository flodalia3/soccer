package it.accenture.soccer.model;

import it.accenture.soccer.model.abstractions.WithId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;
import java.util.stream.Stream;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Team implements WithId<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    private String name;
    private String logo;
    private String motto;
    private int titles;
    @ManyToOne
    @JoinColumn(name="CITY_ID", referencedColumnName = "ID", nullable=false)
    private City city;

    @OneToMany(mappedBy = "homeTeam")
    private Set<Match> homeMatches;
    @OneToMany(mappedBy = "awayTeam")
    private Set<Match> awayMatches;
    @OneToMany(mappedBy = "team")
    private Set<Player> players;

    public int calculateHomePoints(){
        int points = 0;
        return homeMatches.stream().reduce(0, (a, m) -> {
            return a + (m.getHomeScore() > m.getAwayScore() ? 3 : m.getHomeScore() == m.getAwayScore() ? 1 : 0);
        }, (a1, a2) -> a1 + a2 );
    }

    public int calculateAwayPoints(){
        int points = 0;
        return homeMatches.stream().reduce(0, (a, m) -> {
            return a + (m.getHomeScore() < m.getAwayScore() ? 3 : m.getHomeScore() == m.getAwayScore() ? 1 : 0);
        }, (a1, a2) -> a1 + a2 );
    }

}
