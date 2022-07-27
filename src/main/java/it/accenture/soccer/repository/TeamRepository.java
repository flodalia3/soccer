package it.accenture.soccer.repository;

import it.accenture.soccer.model.Team;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Profile("jpa")
public interface TeamRepository extends JpaRepository<Team, Long> {

}
