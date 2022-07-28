package it.accenture.soccer.controllers;

import it.accenture.soccer.dtos.TeamDTO;
import it.accenture.soccer.mapper.TeamMapper;
import it.accenture.soccer.services.implementations.TeamCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
        return ResponseEntity.ok(TeamMapper.INSTANCE.fromTeams(rs));
    }

    @GetMapping("{id}")
    public ResponseEntity<TeamDTO> getOne(@PathVariable long id) {
        var rs = crudService.findById(id);
        if (rs.isPresent())
            return ResponseEntity.ok(TeamMapper.INSTANCE.fromTeam(rs.get()));
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }


}
