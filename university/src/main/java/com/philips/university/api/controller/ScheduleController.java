package com.philips.university.api.controller;

import com.philips.university.api.dto.ScheduleInputDTO;
import com.philips.university.api.dto.ScheduleOutputDTO;
import com.philips.university.api.mapper.SchedulerMapper;
import com.philips.university.domain.model.Schedule;
import com.philips.university.domain.service.CourseService;
import com.philips.university.domain.service.ProfessorService;
import com.philips.university.domain.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/university")
@RequiredArgsConstructor
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private ProfessorService professorService;

    @Autowired
    private CourseService courseService;

    private final SchedulerMapper schedulerMapper;

    @PostMapping("/schedule")
    public ScheduleOutputDTO createScedule(@RequestBody @Valid ScheduleInputDTO inputDTO)
    {
        Schedule schedule = schedulerMapper.mapToDomainModel(inputDTO);
        return schedulerMapper.mapFromDomainModel(scheduleService.create(schedule));
    }

    @GetMapping("/schedule")
    public List<ScheduleOutputDTO> getSchedule()
    {
        List<Schedule> schedules = scheduleService.list();
        return schedulerMapper.mapToCollection(schedules);
    }

    @DeleteMapping("/schedule/{scheduleId}")
    public void deleteSchedule(Integer scheduleId)
    {
        scheduleService.delete(scheduleId);
    }
}
