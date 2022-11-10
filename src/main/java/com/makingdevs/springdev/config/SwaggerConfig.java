package com.makingdevs.springdev.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

  @Bean
  public OpenAPI openAPI() {
    return new OpenAPI()
      .info(
        new Info()
          .title("Spring Dev API")
          .version("0.1.0")
          .description("Spring Dev API v0.1.0")
      );
  }

}
