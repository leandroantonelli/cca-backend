package br.com.cca.config;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.sql.SQLException;

/**
 * User: Leandro Antonelli
 * Date: 02/06/20
 */
@Configuration
@AutoConfigureAfter(ConfigurationForDataSource.class)
public class ConfigurationForRepository {

    @Bean
    NamedParameterJdbcTemplate repositoryTemplate(JdbcTemplate jdbcTemplate) throws SQLException {

        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        return namedParameterJdbcTemplate;

    }
}
