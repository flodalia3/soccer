package it.accenture.soccer.services.implementations;

import it.accenture.soccer.model.Player;
import it.accenture.soccer.repository.PlayerRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class PlayerCrudService extends CrudService<Player, Long, PlayerRepository>{

    public PlayerCrudService(PlayerRepository repo) {
        super(repo, Player.class);
    }
    public List<Player> findTop5SortByGoal(){
        return repo.find10SortByGoal(PageRequest.of(0, 5)).getContent();
    }

//    public List<Player> findTop10SortByAssist(){
//        return repo.find10SortByAssist();
//    }

    public List<Player> findTop5SortByAssist(){
        return repo.find10SortByAssist(PageRequest.of(0, 5)).getContent();
    }

    public List<Player> getPlayerScoreMoreThan(int nGoals){
        return repo.findByGoalCountGreaterThan(nGoals);
    }
}
