package dev.innov8.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
@ComponentScan(basePackages="dev.innov8")
public class AppConfig {

    /**
     * Declares that our application will make use of the Spring-provided implementation
     * of the MessageSource interface: ResourceBundleMessageSource.
     *
     * @return a ResourceBundleMessageSource bean managed by the Spring container
     */
    @Bean
    public ResourceBundleMessageSource messageSource() {

        ResourceBundleMessageSource source = new ResourceBundleMessageSource();
        source.setBasename("messages/demo");
        source.setUseCodeAsDefaultMessage(true);
        return source;
    }

}
