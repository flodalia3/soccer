package it.accenture.soccer.controllers;

import it.accenture.soccer.dtos.TeamDTO;
import it.accenture.soccer.mapper.TeamMapper;
import it.accenture.soccer.model.Team;
import it.accenture.soccer.services.implementations.TeamCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.StreamSupport;

@RestController
@RequestMapping("team")
public class TeamController {
    private TeamCrudService crudService;

    @Autowired
    public TeamController(TeamCrudService crudService) {
        this.crudService = crudService;
    }

    @GetMapping
    public ResponseEntity<Iterable<TeamDTO>> getAll() {
        var rs = crudService.getAll();
        // var dtos = StreamSupport.stream(cls.spliterator(), false).map(TeamMapper.INSTANCE::fromTeam).toList();

        return ResponseEntity.ok(TeamMapper.INSTANCE.fromTeams(rs));
    }


}
