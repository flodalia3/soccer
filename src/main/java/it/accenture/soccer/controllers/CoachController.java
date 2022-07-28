package it.accenture.soccer.controllers;

import it.accenture.soccer.dtos.CoachDTO;
import it.accenture.soccer.dtos.CoachDTO;
import it.accenture.soccer.mapper.CoachMapper;
import it.accenture.soccer.mapper.CoachMapper;
import it.accenture.soccer.model.Coach;
import it.accenture.soccer.services.implementations.CoachCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.StreamSupport;

@RestController
@RequestMapping("coach")
public class CoachController {
    private CoachCrudService crudService;

    @Autowired
    public CoachController(CoachCrudService crudService) {
        this.crudService = crudService;
    }

    @GetMapping
    public ResponseEntity<Iterable<CoachDTO>> getAll() {
        var rs = crudService.getAll();
        return ResponseEntity.ok(CoachMapper.INSTANCE.fromCoaches(rs));
    }

    @GetMapping("{id}")
    public ResponseEntity<CoachDTO> getOne(@PathVariable long id) {
        var rs = crudService.findById(id);
        if (rs.isPresent())
            return ResponseEntity.ok(CoachMapper.INSTANCE.fromCoach(rs.get()));
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }


}
