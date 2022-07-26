package it.accenture.soccer.model;

import it.accenture.soccer.model.abstractions.WithId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "CAPTAIN")
public class Captain implements WithId<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @ManyToOne
    @JoinColumn(name="PLAYER_ID", referencedColumnName = "ID", nullable=false)
    private Player player;
    @ManyToOne
    @JoinColumn(name="TEAM_ID", referencedColumnName = "ID", nullable=false)
    private Team team;
    @ManyToOne
    @JoinColumn(name="MATCH_ID", referencedColumnName = "ID", nullable=false)
    private Match match;
}
