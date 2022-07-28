package it.accenture.soccer.controllers;

import it.accenture.soccer.dtos.PlayerDTO;
import it.accenture.soccer.mapper.PlayerMapper;
import it.accenture.soccer.services.implementations.PlayerCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @GetMapping("{id}")
    public ResponseEntity<PlayerDTO> getOne(@PathVariable long id) {
        var rs = crudService.findById(id);
        if (rs.isPresent())
            return ResponseEntity.ok(PlayerMapper.INSTANCE.fromPlayer(rs.get()));
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @GetMapping("{goals}")
    public ResponseEntity<Iterable<PlayerDTO>> getPlayerScoreMoreThan(@PathVariable int goals){
        var rs = crudService.getPlayerScoreMoreThan(goals);
        return ResponseEntity.ok(PlayerMapper.INSTANCE.fromPlayers(rs));
    }

    @GetMapping("topgoals")
    public ResponseEntity<Iterable<PlayerDTO>> findTopScorers(){
        var rs = crudService.findTop10SortByGoal();
        return ResponseEntity.ok(PlayerMapper.INSTANCE.fromPlayers(rs));
    }

    @GetMapping("topassists")
    public ResponseEntity<Iterable<PlayerDTO>> findTopAssistMen(){
        var rs = crudService.findTop10SortByAssist();
        return ResponseEntity.ok(PlayerMapper.INSTANCE.fromPlayers(rs));
    }
}
