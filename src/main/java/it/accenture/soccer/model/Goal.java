package it.accenture.soccer.model;

import it.accenture.soccer.model.abstractions.WithId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "GOAL")
public class Goal implements WithId<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    private int minute;
    @ManyToOne
    @JoinColumn(name="ASSIST", referencedColumnName = "ID", nullable=true)
    private Player assistPlayer;
    @ManyToOne
    @JoinColumn(name="PLAYER_ID", referencedColumnName = "ID", nullable=false)
    private Player scorer;
    @ManyToOne
    @JoinColumn(name="MATCH_ID", referencedColumnName = "ID", nullable=false)
    private Match match;
    @ManyToOne
    @JoinColumn(name="TEAM_ID", referencedColumnName = "ID", nullable=false)
    private Team team;
}
