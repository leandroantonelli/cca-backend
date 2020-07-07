package br.com.cca.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * User: Leandro Antonelli
 * Date: 02/06/20
 */
@Configuration
public class ConfigurationForDataSource {

    @Value("${cca.datasource.db.host:#{null}}")
    private String host;

    @Value("${cca.datasource.db.port:#{null}}")
    private String port;

    @Value("${cca.datasource.db.dbName:#{null}}")
    private String dbName;

    @Value("${cca.datasource.db.schema:#{null}}")
    private String dbSchema;

    @Value("${cca.datasource.db.user:#{null}}")
    private String user;

    @Value("${cca.datasource.db.password:#{null}}")
    private String password;

    @Bean(name = "dataSource")
    public DataSource dataSource() {

        DataSource dataSource;

        try {

            dataSource = configureLocalDataSource();

        } catch (Exception e) {

            throw e;
        }

        return dataSource;
    }

    private DataSource configureLocalDataSource() {

        HikariConfig config = new HikariConfig();
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        config.setPoolName("CCAHikaripool-" + Math.random());
        config.setJdbcUrl("jdbc:postgresql://" + host + ":" + port + "/" + dbName);
        config.setSchema(dbSchema);
        config.setUsername(user);
        config.setPassword(password);
        config.setAutoCommit(true);
        config.setDriverClassName("org.postgresql.Driver");

        return new HikariDataSource(config);
    }
}
