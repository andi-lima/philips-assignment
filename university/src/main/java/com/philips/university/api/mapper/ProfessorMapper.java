package com.philips.university.api.mapper;

import com.philips.university.api.dto.ProfessorInputDTO;
import com.philips.university.api.dto.ProfessorOutputDTO;
import com.philips.university.domain.model.Professor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProfessorMapper {

    @Mapping(source = "inputDTO.name", target = "name")
    @Mapping(source = "inputDTO.departmentId", target = "department.id")
    Professor mapToDomainModel(ProfessorInputDTO inputDTO);

    @Mapping(source = "professor.name", target = "name")
    @Mapping(source = "professor.department.id", target = "departmentId")
    ProfessorOutputDTO mapFromDomainModel(Professor professor);

    List<ProfessorOutputDTO> mapToCollection(List<Professor> professors);
}
