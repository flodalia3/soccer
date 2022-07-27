package it.accenture.soccer.mapper;

import it.accenture.soccer.dtos.RefereeDTO;
import it.accenture.soccer.dtos.TeamDTO;
import it.accenture.soccer.model.Referee;
import it.accenture.soccer.model.Team;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = PlayerMapper.class)
public interface TeamMapper {

    TeamMapper INSTANCE = Mappers.getMapper(TeamMapper.class);

    @Mapping(source = "city.name", target = "cityName")
    @Mapping(source = "players", target = "playerDTOs")
    TeamDTO fromTeam(Team t);

    Team fromTeamDTO(TeamDTO teamDto);

    Iterable<TeamDTO> fromTeams (Iterable<Team> referees);

}
