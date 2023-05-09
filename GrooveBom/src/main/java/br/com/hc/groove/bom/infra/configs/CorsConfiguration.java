package br.com.hc.groove.bom.infra.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/* @Configuration
public class CorsConfiguration implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
            // .allowedOrigins("http://localhost:8080", "file:///C:/Users/mtech_user/Desktop/ProjetoTCC2/index.html")
            // .allowedOrigins("file:///C:/Users/mtech_user/Desktop/ProjetoTCC2/index.html")
            .allowedOrigins("*")
            .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD", "TRACE", "CONNECT");
    }
} 
 */


// @Configuration
// public class CorsConfiguration implements WebMvcConfigurer {
//     @Override
//     public void addCorsMappings(CorsRegistry registry) {
//         registry.addMapping("/**")
//                 .allowedOrigins("*")
//                 .allowedMethods("*")
//                 .allowedHeaders("*");
//     }
// }