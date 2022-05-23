package com.philips.university.domain.repository;

import com.philips.university.api.dto.SearchOutputDTO;
import com.philips.university.domain.model.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class SearchRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private String query =
            "select p.id, p.name, array_agg(c.name) as courses\n" +
            "from professor p\n" +
            "inner join schedule s on p.id = s.professor_id\n" +
            "inner join course c on c.id = s.course_id\n" +
            "where p.id in (select professor_id from schedule)\n" +
            "group by p.id;";


    public List<Search> querySearch()
    {
        return jdbcTemplate.query(query, new SearchRowMapper());
    }

    class SearchRowMapper implements RowMapper<Search>
    {
        @Override
        public Search mapRow(ResultSet resultSet, int rownumber) throws SQLException
        {
            Search search = new Search();
            search.setName(resultSet.getString("name"));
            String[] coursesArray = (String[]) resultSet.getArray("courses").getArray();
            search.setCourses(List.of(coursesArray));
            return search;
        }
    }

}
