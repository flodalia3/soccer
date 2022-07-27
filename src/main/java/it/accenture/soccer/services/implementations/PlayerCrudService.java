package it.accenture.soccer.services.implementations;

import it.accenture.soccer.model.Player;
import it.accenture.soccer.repository.PlayerRepository;
import org.springframework.stereotype.Service;

@Service
public class PlayerCrudService extends CrudService<Player, Long, PlayerRepository>{

    public PlayerCrudService(PlayerRepository repo) {
        super(repo, Player.class);
    }
}
