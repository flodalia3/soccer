package it.accenture.soccer.services.implementations;

import it.accenture.soccer.model.Referee;
import it.accenture.soccer.repository.RefereeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RefereeCrudService extends CrudService<Referee, Long, RefereeRepository>{

    public RefereeCrudService(RefereeRepository repo) {
        super(repo, Referee.class);
    }

//    public Optional<Referee> findById(long id){
//        return repo.findById(id);
//    }
}
