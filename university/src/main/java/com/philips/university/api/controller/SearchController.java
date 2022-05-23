package com.philips.university.api.controller;

import com.philips.university.api.dto.SearchOutputDTO;
import com.philips.university.api.mapper.SearchMapper;
import com.philips.university.domain.model.Search;
import com.philips.university.domain.repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/university")
public class SearchController {

    @Autowired
    private SearchRepository searchRepository;

    @Autowired
    private SearchMapper searchMapper;

    @GetMapping("/search")
    public List<SearchOutputDTO> search()
    {
        List<Search> searches = searchRepository.querySearch();
        return searchMapper.mapToCollection(searches);
    }
}
