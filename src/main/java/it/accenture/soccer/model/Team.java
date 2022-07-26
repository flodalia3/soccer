package it.accenture.soccer.model;

import it.accenture.soccer.model.abstractions.WithId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

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
}
