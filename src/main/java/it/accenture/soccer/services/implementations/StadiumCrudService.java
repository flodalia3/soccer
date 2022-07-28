package it.accenture.soccer.services.implementations;

import it.accenture.soccer.model.Stadium;
import it.accenture.soccer.repository.StadiumRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StadiumCrudService extends CrudService<Stadium, Long, StadiumRepository>{

    public StadiumCrudService(StadiumRepository repo) {
        super(repo, Stadium.class);
    }
}
