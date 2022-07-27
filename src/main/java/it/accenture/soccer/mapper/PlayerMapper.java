package it.accenture.soccer.mapper;

import it.accenture.soccer.dtos.PlayerDTO;
import it.accenture.soccer.model.Player;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PlayerMapper {
    PlayerMapper INSTANCE = Mappers.getMapper(PlayerMapper.class);

    @Mapping(source = "team.id", target = "teamId")
    @Mapping(source = "team.name", target = "teamName")
    @Mapping(source = "role.id", target = "roleId")
    @Mapping(source = "role.name", target = "roleName")
    @Mapping(source = "birthCity.name", target = "birthCity")
    @Mapping(target = "numGoals", expression = "java(p.getGoals().size())")
    @Mapping( target = "numAssists", expression = "java(p.getAssists().size())")
    PlayerDTO fromPlayer (Player p);

    @Mapping(target = "team.id", source = "teamId")
    @Mapping(target = "team.name", source = "teamName")
    @Mapping(target = "role.id", source = "roleId")
    @Mapping(target = "role.name", source = "roleName")
    @Mapping(target = "birthCity.name", source = "birthCity")
    Player toPlayer (PlayerDTO cDTO);

    Iterable<PlayerDTO> fromPlayers (Iterable<Player> players);


}
