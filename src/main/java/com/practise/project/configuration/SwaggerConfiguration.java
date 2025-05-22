package com.practise.project.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import lombok.extern.slf4j.Slf4j;


@Configuration
@Slf4j
public class SwaggerConfiguration {
	
	@Value("${spring.application.name}")
	 private String appName;
	  
	  @Bean
	  OpenAPI openAPI() {
	    log.info("Configuring Swagger OpenAPI");
	    return (new OpenAPI()).info((new Info()).title(this.appName + " API'S")
	        .description(this.appName + " APIs").version("1.0"))
	      .addSecurityItem((new SecurityRequirement()).addList("BearerAuth"))
	      .components((new Components())
	        .addSecuritySchemes("BearerAuth", (new SecurityScheme())
	          .type(SecurityScheme.Type.HTTP)
	          .scheme("bearer")
	          .bearerFormat("JWT")));
	  }

}
