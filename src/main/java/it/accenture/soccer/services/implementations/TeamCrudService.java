package it.accenture.soccer.services.implementations;

import it.accenture.soccer.model.Team;
import it.accenture.soccer.repository.TeamRepository;
import org.springframework.stereotype.Service;

@Service
public class TeamCrudService extends CrudService<Team, Long, TeamRepository>{

    public TeamCrudService(TeamRepository repo) {
        super(repo, Team.class);
    }
}
