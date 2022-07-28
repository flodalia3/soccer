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
@Table(name = "MATCH")
public class Match implements WithId<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "HOME_SCORE")
    private int homeScore;
    @Column(name = "AWAY_SCORE")
    private int awayScore;
    @Column(name = "GAME_DATE")
    private LocalDate gameDate;
    @Column(name = "EXTRA_TIME1")
    private int extraTimeFirstHalf;
    @Column(name = "EXTRA_TIME2")
    private int extraTimeSecondHalf;
    @ManyToOne
    @JoinColumn(name="STADIUM_ID", referencedColumnName = "ID", nullable=false)
    private Stadium stadium;
    @ManyToOne
    @JoinColumn(name="HOME_TEAM", referencedColumnName = "ID", nullable=false)
    private Team homeTeam;
    @ManyToOne
    @JoinColumn(name="AWAY_TEAM", referencedColumnName = "ID", nullable=false)
    private Team awayTeam;
    @ManyToOne
    @JoinColumn(name="REFEREE_ID", referencedColumnName = "ID", nullable=false)
    private Referee referee;
    @OneToMany(mappedBy = "match")
    private Set<Goal> goals;


}
