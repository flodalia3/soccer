package it.accenture.soccer.repository;

import it.accenture.soccer.model.Player;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
@Profile("jpa")
public interface PlayerRepository extends JpaRepository<Player, Long> {
    //public Set<Player> findTop3ByGoalsCount();
    @Query("SELECT p FROM Player p WHERE SIZE(p.goals)>=:nGoals")
    public List<Player> findByGoalCountGreaterThan(@Param("nGoals") int nGoals);

}
