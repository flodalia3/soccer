package it.accenture.soccer.controllers;

import it.accenture.soccer.dtos.TeamDTO;
import it.accenture.soccer.exceptions.EntityNotFoundException;
import it.accenture.soccer.mapper.TeamMapper;
import it.accenture.soccer.model.City;
import it.accenture.soccer.model.Team;
import it.accenture.soccer.services.implementations.TeamCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.net.URI;
import java.net.URISyntaxException;

@RestController
@CrossOrigin
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

    @PostMapping
    public ResponseEntity<?> addOne(@RequestBody TeamDTO tdto){
        Team t = TeamMapper.INSTANCE.fromTeamDTO(tdto);
        try {
            Team tsaved = crudService.saveOrUpdate(t);
            var dto = TeamMapper.INSTANCE.fromTeam(tsaved);
            URI uri = new URI("localhost:8080/team/" + tdto.getId());
            return ResponseEntity.created(uri).body(dto);
        } catch (URISyntaxException e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }


}
