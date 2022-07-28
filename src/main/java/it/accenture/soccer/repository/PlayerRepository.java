package it.accenture.soccer.repository;

import it.accenture.soccer.model.Player;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Profile("jpa")
public interface PlayerRepository extends JpaRepository<Player, Long> {
    //public Set<Player> findTop3ByGoalsCount();
    @Query("SELECT p FROM Player p WHERE SIZE(p.goals)>=:nGoals")
    public List<Player> findByGoalCountGreaterThan(@Param("nGoals") int nGoals);

    @Query (value = "SELECT p FROM Player p WHERE SIZE(p.goals)>0 ORDER BY SIZE(p.goals) DESC, SIZE(p.assists) DESC")
    public Page<Player> find10SortByGoal(Pageable pageable);

//    @Query ("SELECT p FROM Player p WHERE SIZE(p.assists)>0 ORDER BY SIZE(p.assists) DESC, SIZE(p.goals) DESC")
//    public List<Player> find10SortByAssist();

    @Query ("SELECT p FROM Player p WHERE SIZE(p.assists)>0 ORDER BY SIZE(p.assists) DESC, SIZE(p.goals) DESC")
    public Page<Player> find10SortByAssist(Pageable pageable);
}
