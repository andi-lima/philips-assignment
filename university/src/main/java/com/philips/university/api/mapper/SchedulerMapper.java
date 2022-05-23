package com.philips.university.api.mapper;

import com.philips.university.api.dto.ScheduleInputDTO;
import com.philips.university.api.dto.ScheduleOutputDTO;
import com.philips.university.domain.model.Schedule;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SchedulerMapper {

    @Mapping(source = "inputDTO.professorId", target = "professor.id")
    @Mapping(source = "inputDTO.courseId", target = "course.id")
    @Mapping(source = "inputDTO.semester", target = "semester")
    @Mapping(source = "inputDTO.year", target = "year")
    Schedule mapToDomainModel(ScheduleInputDTO inputDTO);

//    @Mapping(source = "schedule.id", target = "id", ignore = true)
    @Mapping(source = "schedule.professor.id", target = "professorId")
    @Mapping(source = "schedule.course.id", target = "courseId")
    @Mapping(source = "schedule.semester", target = "semester")
    @Mapping(source = "schedule.year", target = "year")
    ScheduleOutputDTO mapFromDomainModel(Schedule schedule);

    List<ScheduleOutputDTO> mapToCollection(List<Schedule> schedules);
}
