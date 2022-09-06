package com.epam.movie_rating.config;//package com.epam.movie_rating.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Map;

@Slf4j
@Component
public class StoredProcedure {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcCall simpleJdbcCallProcedure;


    @PostConstruct
    public void init() {
        jdbcTemplate.setResultsMapCaseInsensitive(true);
        simpleJdbcCallProcedure = new SimpleJdbcCall(jdbcTemplate)
                .withFunctionName("rate_average");
//                .withProcedureName("rate_average")
//                .withoutProcedureColumnMetaDataAccess();
//                .returningResultSet("rate",
//                        BeanPropertyRowMapper.newInstance(Integer.class));

    }

    private static final String SQL_STORED_PROC = new StringBuilder()
            .append(" CREATE OR REPLACE FUNCTION rate_average(filmId IN bigint) ")
            .append(" RETURNS integer ")
            .append(" AS $$ ")
            .append(" ")
            .append("   BEGIN ")
            .append("   SELECT AVG(rate) FROM user_film WHERE film_id = filmId; ")
            .append("   RETURN rate; ")
            .append(" END; ")
            .append(" $$ LANGUAGE plpgsql")
            .toString();

    public int start(Long filmId) {

        log.info("Creating Store Procedures and Function...");
        jdbcTemplate.execute(SQL_STORED_PROC);
        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("filmid", filmId);
        Map<String, Object> output = simpleJdbcCallProcedure.execute(in);

        Integer  rate = (Integer) output.get("filmid");
        return rate;

    }
}
