package br.com.cca.commons.repository;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * User: Leandro Antonelli
 * Date: 02/06/20
 */
@Log4j2
@Repository
public class AbstractRepository {

    @Autowired
    private NamedParameterJdbcTemplate repositoryTemplate;

    public <T> List<T> query(String sql, RowMapper<T> rowMapper ) {

        try {
            return repositoryTemplate.query( sql, rowMapper );
        } catch (Exception e) {
            log.error("Problema ao executar o sql {} com os parametros: {}", sql, e);
            throw e;
        }
    }

    public <T> List<T> query(String sql, Map<String, Object> parameters, RowMapper<T> rowMapper ) {

        try {
            return repositoryTemplate.query( sql, parameters, rowMapper );
        } catch (Exception e) {
            log.error("Problema ao executar o sql {} com os parametros: {}", sql, parameters, e);
            throw e;
        }
    }

    public <T> T queryForObject( String sql, Map<String, Object> parameters, RowMapper<T> rowMapper ) {

        try {
            return repositoryTemplate.queryForObject( sql, parameters, rowMapper );
        } catch ( EmptyResultDataAccessException e ) {
            return null;
        } catch (Exception e) {
            log.error("Problema ao executar o sql {} com os parametros: {}", sql, parameters, e);
            throw e;
        }
    }

    public Long insert( String sql, Map<String, Object> params ) {

        final KeyHolder keyHolder = new GeneratedKeyHolder();

        MapSqlParameterSource parameters = new MapSqlParameterSource( params );

        repositoryTemplate.update( sql, parameters, keyHolder );

        Long id = getKeyHolder(keyHolder);

        return id;

    }

    public void update(String dsSql, Map<String, Object> params) {

        repositoryTemplate.update(dsSql, params);
    }

    public void delete(String dsSql, Map<String, Object> params) {

        repositoryTemplate.update(dsSql, params);
    }

    private Long getKeyHolder(KeyHolder keyHolder) {

        return keyHolder.getKey() != null ? keyHolder.getKey().longValue() : null;
    }

}
