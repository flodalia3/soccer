package it.accenture.soccer.mapper;

import it.accenture.soccer.dtos.RefereeDTO;
import it.accenture.soccer.model.Referee;
import org.mapstruct.Mapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.text.SimpleDateFormat;

@Mapper
public interface RefereeMapper {
    RefereeMapper INSTANCE = Mappers.getMapper(RefereeMapper.class);
    SimpleDateFormat formatter = new SimpleDateFormat(
            "dd/MM/yyyy");
    @Mapping(target = "cityName", source = "birthCity.name")
    RefereeDTO fromReferee (Referee r);

    @Mapping(target = "birthCity.name", source = "cityName")
    Referee toReferee (RefereeDTO cDTO);

    Iterable<RefereeDTO> fromReferees (Iterable<Referee> referees);
}
/*
    @Mapping(source = "sector.id", target = "sectorId")
    @Mapping(source = "sector.name", target = "sectorName")
    CourseDTO toCourseDto(Course course);

    @Mapping(source = "sectorId", target = "sector.id")
    @Mapping(source = "sectorName", target = "sector.name")
    Course toCourse(CourseDTO courseDto);

 */