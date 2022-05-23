package com.philips.university.domain.service;

import com.philips.university.domain.model.Course;
import com.philips.university.domain.model.Professor;
import com.philips.university.domain.model.Schedule;
import com.philips.university.domain.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private CourseService courseService;

    @Autowired
    private ProfessorService professorService;

    @Transactional
    public Schedule create(Schedule schedule)
    {
        Course course = courseService.findById(schedule.getCourse().getId());
        Professor professor = professorService.findById(schedule.getProfessor().getId());

        schedule.setCourse(course);
        schedule.setProfessor(professor);

        return scheduleRepository.save(schedule);
    }

    public List<Schedule> list()
    {
        return scheduleRepository.findAll();
    }

    @Transactional
    public void delete(Integer scheduleId)
    {
        scheduleRepository.delete(scheduleRepository.getReferenceById(scheduleId));
        scheduleRepository.flush();
    }
}
