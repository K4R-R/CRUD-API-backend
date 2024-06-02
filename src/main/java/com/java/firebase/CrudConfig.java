package com.java.firebase;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CrudConfig implements WebMvcConfigurer{

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // Define the endpoint pattern for which CORS should be configured
                .allowedOrigins("http://localhost:3000")  // Allow requests from this origin
                .allowedMethods("GET", "POST", "PUT", "DELETE")  // Allow these HTTP methods
                .allowCredentials(true);  // Allow sending cookies
    }

}
