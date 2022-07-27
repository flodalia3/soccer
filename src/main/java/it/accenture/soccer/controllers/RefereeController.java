package it.accenture.soccer.controllers;

import it.accenture.soccer.dtos.RefereeDTO;
import it.accenture.soccer.mapper.RefereeMapper;
import it.accenture.soccer.model.Referee;
import it.accenture.soccer.services.implementations.RefereeCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
       // var dtos = StreamSupport.stream(cls.spliterator(), false).map(RefereeMapper.INSTANCE::fromReferee).toList();

        return ResponseEntity.ok(RefereeMapper.INSTANCE.fromReferees(rs));
    }


}
