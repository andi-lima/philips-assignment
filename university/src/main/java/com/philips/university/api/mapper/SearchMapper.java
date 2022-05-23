package com.philips.university.api.mapper;

import com.philips.university.api.dto.SearchOutputDTO;
import com.philips.university.domain.model.Search;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SearchMapper {

    List<SearchOutputDTO> mapToCollection(List<Search> searchList);
}
