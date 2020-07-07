package br.com.cca;

import br.com.cca.config.ConfigurationForCcaConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * User: Leandro Antonelli
 * Date: 02/06/20
 */
@SpringBootApplication(scanBasePackages = {"br.com.cca"})
@EnableConfigurationProperties(ConfigurationForCcaConfig.class)
public class CCARun extends SpringBootServletInitializer {

    public static void main(String[] args) {

        SpringApplication.run(CCARun.class, args);

    }

    @Override
    protected final SpringApplicationBuilder configure(final SpringApplicationBuilder application) {

        return application.sources(CCARun.class);

    }
}
