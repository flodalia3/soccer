package it.accenture.soccer.services.implementations;

import it.accenture.soccer.model.Coach;
import it.accenture.soccer.repository.CoachRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CoachCrudService extends CrudService<Coach, Long, CoachRepository>{

    public CoachCrudService(CoachRepository repo) {
        super(repo, Coach.class);
    }
}
