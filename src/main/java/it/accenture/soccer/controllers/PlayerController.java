package it.accenture.soccer.controllers;

import it.accenture.soccer.dtos.PlayerDTO;
import it.accenture.soccer.mapper.PlayerMapper;
import it.accenture.soccer.model.Player;
import it.accenture.soccer.services.implementations.PlayerCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.StreamSupport;

@RestController
@RequestMapping("player")
public class PlayerController {
    private PlayerCrudService crudService;

    @Autowired
    public PlayerController(PlayerCrudService crudService) {
        this.crudService = crudService;
    }

    @GetMapping
    public ResponseEntity<Iterable<PlayerDTO>> getAll() {
        var rs = crudService.getAll();
        // var dtos = StreamSupport.stream(cls.spliterator(), false).map(PlayerMapper.INSTANCE::fromPlayer).toList();

        return ResponseEntity.ok(PlayerMapper.INSTANCE.fromPlayers(rs));
    }

    @GetMapping("{goals}")
    public ResponseEntity<Iterable<PlayerDTO>> getPlayerScoreMoreThan(@PathVariable int goals){
        var rs = crudService.getPlayerScoreMoreThan(goals);
        return ResponseEntity.ok(PlayerMapper.INSTANCE.fromPlayers(rs));
    }


}
