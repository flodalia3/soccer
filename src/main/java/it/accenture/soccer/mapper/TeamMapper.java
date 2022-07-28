package it.accenture.soccer.mapper;

import it.accenture.soccer.dtos.RefereeDTO;
import it.accenture.soccer.dtos.TeamDTO;
import it.accenture.soccer.model.Match;
import it.accenture.soccer.model.Referee;
import it.accenture.soccer.model.Team;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;
import java.util.concurrent.Callable;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

@Mapper(uses = PlayerMapper.class)
public interface TeamMapper {

    TeamMapper INSTANCE = Mappers.getMapper(TeamMapper.class);
//    Function<Match, Integer> homePoints = (x) -> {
//        if (x.getGameDate().isAfter(LocalDate.now()))
//            return 0;
//        return x.getHomeScore() > x.getAwayScore() ? 3 : x.getHomeScore() == x.getAwayScore() ? 1 : 0;
//    };

//    Function<Match, Integer> awayPoints = (x) -> {
//        if (x.getGameDate().isAfter(LocalDate.now()))
//            return 0;
//        return x.getHomeScore() < x.getAwayScore() ? 3 : x.getHomeScore() == x.getAwayScore() ? 1 : 0;
//    };
//    int points = 0;
    @Mapping(source = "city.name", target = "cityName")
    @Mapping(source = "players", target = "playerDTOs")
    @Mapping(target = "points", expression =
            "java((t.calculateHomePoints() + t.calculateAwayPoints()))")
    TeamDTO fromTeam(Team t);

    Team fromTeamDTO(TeamDTO teamDto);

    Iterable<TeamDTO> fromTeams (Iterable<Team> referees);

}
