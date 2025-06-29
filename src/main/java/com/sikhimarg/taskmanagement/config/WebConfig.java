package com.sikhimarg.taskmanagement.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration  // ➤ Markiert die Klasse als Konfiguration
public class WebConfig implements WebMvcConfigurer {
    // ➤ Konfiguriert CORS für die gesamte Anwendung
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // ➤ Alle Pfade
                .allowedOrigins("http://localhost:4200")  // ➤ Erlaube z.B. Angular-Frontend
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*");
    }
}
