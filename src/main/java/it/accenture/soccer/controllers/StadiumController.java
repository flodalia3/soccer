package it.accenture.soccer.controllers;

import it.accenture.soccer.dtos.StadiumDTO;
import it.accenture.soccer.mapper.StadiumMapper;
import it.accenture.soccer.model.Stadium;
import it.accenture.soccer.services.implementations.StadiumCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.StreamSupport;

@RestController
@RequestMapping("stadium")
public class StadiumController {
    private StadiumCrudService crudService;

    @Autowired
    public StadiumController(StadiumCrudService crudService) {
        this.crudService = crudService;
    }

    @GetMapping
    public ResponseEntity<Iterable<StadiumDTO>> getAll() {
        var rs = crudService.getAll();
        return ResponseEntity.ok(StadiumMapper.INSTANCE.fromStadiums(rs));
    }


}
