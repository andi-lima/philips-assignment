package com.philips.university.api.controller;

import com.philips.university.api.dto.ProfessorInputDTO;
import com.philips.university.api.dto.ProfessorOutputDTO;
import com.philips.university.api.mapper.ProfessorMapper;
import com.philips.university.domain.model.Professor;
import com.philips.university.domain.service.ProfessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/university")
@RequiredArgsConstructor
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    private final ProfessorMapper professorMapper;

    @PostMapping("/professor")
    @ResponseStatus(HttpStatus.CREATED)
    public ProfessorOutputDTO createProfessor(@RequestBody @Valid ProfessorInputDTO inputDTO)
    {
        Professor professor = professorMapper.mapToDomainModel(inputDTO);
        return professorMapper.mapFromDomainModel(professorService.create(professor));
    }

    @GetMapping("/professor")
    public List<ProfessorOutputDTO> getProfessor()
    {
        List<Professor> professors = professorService.list();
        return professorMapper.mapToCollection(professors);
    }

    @GetMapping("/professor/{professorId}")
    public ProfessorOutputDTO getById(@PathVariable Integer professorId)
    {
        Professor professor = professorService.findById(professorId);
        return professorMapper.mapFromDomainModel(professor);
    }

    @DeleteMapping("/professor/{professorId}")
    public void deleteProfessor(@PathVariable Integer professorId)
    {
        professorService.delete(professorId);
    }
}
