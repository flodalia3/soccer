package it.accenture.soccer.mapper;

import it.accenture.soccer.dtos.StadiumDTO;
import it.accenture.soccer.dtos.StadiumDTO;
import it.accenture.soccer.model.Stadium;
import it.accenture.soccer.model.Stadium;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StadiumMapper {
    StadiumMapper INSTANCE = Mappers.getMapper(StadiumMapper.class);

    @Mapping(target = "upcomingMatches", expression = "java(s.getNumFutureMatches())")
    @Mapping(target = "pastMatches", expression = "java(s.getNumMatchesPlayed())")
    StadiumDTO fromStadium (Stadium s);

    Stadium toStadium (StadiumDTO sDTO);

    Iterable<StadiumDTO> fromStadiums (Iterable<Stadium> players);




}
