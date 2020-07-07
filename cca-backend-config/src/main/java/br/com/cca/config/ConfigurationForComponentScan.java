package br.com.cca.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * User: Leandro Antonelli
 * Date: 13/06/20
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan({"br.com.cca"})
public class ConfigurationForComponentScan {
}
