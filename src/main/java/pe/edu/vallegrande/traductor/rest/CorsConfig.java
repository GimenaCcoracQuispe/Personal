package pe.edu.vallegrande.traductor.rest;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.CorsRegistry;
import org.springframework.web.reactive.config.WebFluxConfigurer;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class CorsConfig implements WebFluxConfigurer {
    
    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("springboot-public")
                .pathsToMatch("/api/**") 
                .build();
    }

    @Bean
    public OpenAPI apiInfo() {
        return new OpenAPI()
                .addServersItem(new Server().url("https://upgraded-waffle-jvg576xp55jfqp66-8085.app.github.dev"))
                .info(new Info()
                        .title("Traductor Azure")
                        .description("Especificación de REST")
                        .license(new License().name("Valle Grande").url("https://vallegrande.edu.pe"))
                        .version("1.0.0"));
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("https://tu-dominio-permitido.com") 
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true); 
    }
}
