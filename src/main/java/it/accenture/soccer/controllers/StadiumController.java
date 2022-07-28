package it.accenture.soccer.controllers;

import it.accenture.soccer.dtos.StadiumDTO;
import it.accenture.soccer.mapper.StadiumMapper;
import it.accenture.soccer.services.implementations.StadiumCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("{id}")
    public ResponseEntity<StadiumDTO> getOne(@PathVariable long id) {
        var rs = crudService.findById(id);
        if (rs.isPresent())
            return ResponseEntity.ok(StadiumMapper.INSTANCE.fromStadium(rs.get()));
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

}
