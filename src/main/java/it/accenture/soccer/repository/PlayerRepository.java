package it.accenture.soccer.repository;

import it.accenture.soccer.model.Player;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Profile("jpa")
public interface PlayerRepository extends JpaRepository<Player, Long> {

}
