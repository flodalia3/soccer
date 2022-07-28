package it.accenture.soccer.controllers;

import it.accenture.soccer.dtos.RefereeDTO;
import it.accenture.soccer.mapper.RefereeMapper;
import it.accenture.soccer.model.Referee;
import it.accenture.soccer.services.implementations.RefereeCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.StreamSupport;

@RestController
@RequestMapping("referee")
@CrossOrigin
public class RefereeController {
    private RefereeCrudService crudService;

    @Autowired
    public RefereeController(RefereeCrudService crudService) {
        this.crudService = crudService;
    }

    @GetMapping
    public ResponseEntity<Iterable<RefereeDTO>> getAll() {
        var rs = crudService.getAll();
        return ResponseEntity.ok(RefereeMapper.INSTANCE.fromReferees(rs));
    }

    @GetMapping("{id}")
    public ResponseEntity<RefereeDTO> getOne(@PathVariable long id) {
        var rs = crudService.findById(id);
        if (rs.isPresent())
            return ResponseEntity.ok(RefereeMapper.INSTANCE.fromReferee(rs.get()));
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
