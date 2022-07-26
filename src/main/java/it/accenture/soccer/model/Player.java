package it.accenture.soccer.model;

import it.accenture.soccer.model.abstractions.WithId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Player implements WithId<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    private String name;
    private String surname;
    private Date birthDate;
    private int jersey;
    @ManyToOne
    @JoinColumn(name="TEAM_ID", referencedColumnName = "ID", nullable=false)
    private Team team;
    @ManyToOne
    @JoinColumn(name="ROLE_ID", referencedColumnName = "ID", nullable=false)
    private Role role;
    @ManyToOne
    @JoinColumn(name="CITY_ID", referencedColumnName = "ID", nullable=false)
    private City birthCity;
    @OneToMany(mappedBy = "scorer")
    private Set<Goal> goals;
    @OneToMany(mappedBy = "assistPlayer")
    private Set<Goal> assists;
}
