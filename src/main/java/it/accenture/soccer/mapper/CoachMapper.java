package it.accenture.soccer.mapper;

import it.accenture.soccer.dtos.CoachDTO;
import it.accenture.soccer.model.Coach;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CoachMapper {
    CoachMapper INSTANCE = Mappers.getMapper(CoachMapper.class);

    @Mapping(source = "team.id", target = "teamId")
    @Mapping(source = "team.name", target = "teamName")
    @Mapping(source = "birthCity.id", target = "birthCityId")
    @Mapping(source = "birthCity.name", target = "birthCity")
    CoachDTO fromCoach (Coach p);

    @Mapping(target = "team.id", source = "teamId")
    @Mapping(target = "team.name", source = "teamName")
    Coach toCoach (CoachDTO cDTO);

    Iterable<CoachDTO> fromCoaches (Iterable<Coach> players);


}
