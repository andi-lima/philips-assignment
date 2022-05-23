package com.philips.university.api.mapper;

import com.philips.university.api.dto.DepartmentInputDTO;
import com.philips.university.api.dto.DepartmentOutputDTO;
import com.philips.university.domain.model.Department;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {

    @Mapping(source = "inputDTO.name", target = "name")
    Department mapToDomainModel(DepartmentInputDTO inputDTO);

    @Mapping(source = "department.id", target = "id")
    @Mapping(source = "department.name", target = "name")
    DepartmentOutputDTO mapFromDomainModel(Department department);

    List<DepartmentOutputDTO> mapToCollection(List<Department> departments);
}
