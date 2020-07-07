package br.com.cca.config;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * User: Leandro Antonelli
 * Date: 02/06/20
 */
@Configuration
@AutoConfigureAfter(ConfigurationForDataSource.class)
public class ConfigurationForMigration {

    @Value("${cca.datasource.db.schema:#{null}}")
    private String dbSchema;

    @Bean
    Flyway flyway(DataSource dataSource) {
        Flyway flyway = new Flyway();
        flyway.setDataSource(dataSource);
        flyway.setLocations("classpath:db/migration/postgres");
        flyway.setSchemas(dbSchema);
        flyway.repair();
        flyway.migrate();

        return flyway;
    }
}
