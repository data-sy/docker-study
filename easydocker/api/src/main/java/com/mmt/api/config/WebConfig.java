package com.mmt.api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
            //    .allowedOrigins("/*") // 외부에서 들어오는 모든 url 허용
            // 로컬
                // .allowedOrigins(
                //     "http://localhost:8080", "http://localhost", "http://localhost:80", "http://localhost:8000", 
                //     "http://mmt-backend:8080", "http://mmt-front:80", "http://mmt-ai:5000")
            // EC2
                .allowedOrigins(
                    "http://localhost:8080", "http://localhost", "http://localhost:80", "http://localhost:8000", 
                    "http://ec2-user-mmt-backend-1:8080", "http://ec2-user-mmt-front-1:80", "http://ec2-user-mmt-ai-1:5000")                
                .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true) // 클라이언트에서 쿠키를 받기 위해
                .maxAge(3600);
    }
}
