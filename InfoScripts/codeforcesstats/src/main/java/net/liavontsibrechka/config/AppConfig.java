package net.liavontsibrechka.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.ResourceBundle;

@Configuration
public class AppConfig {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public ResourceBundle methodsResources() {
        return ResourceBundle.getBundle("methods");
    }

    @Bean
    public ResourceBundle mainResources() {
        return ResourceBundle.getBundle("main");
    }
}
