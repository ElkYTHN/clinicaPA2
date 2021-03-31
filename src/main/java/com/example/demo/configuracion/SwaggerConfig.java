/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import static springfox.documentation.builders.PathSelectors.regex;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 *
 * @author Elkin Portillo
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    
    @Bean
    public Docket getDocket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.demo.controladores"))
                .paths(regex("/ws.*"))
                .build()
                .apiInfo(getApiInfo());
    }
    
    private ApiInfo getApiInfo(){
        return new ApiInfo("Aplicación de Clinica"
                , "Contiene una Rest Api y una aplicación web"
                , "0.0.0.1"
                , "http://uth.hn"
                , "Programación Avanzada 2"
                , "PA2"
                , "PA2 URL") ;
    }
}

