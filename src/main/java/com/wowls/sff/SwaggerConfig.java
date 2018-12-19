package com.wowls.sff;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	   @Bean
	    public Docket api() {
	        return new Docket(DocumentationType.SWAGGER_2)
	                .select()
	                .apis(RequestHandlerSelectors.basePackage("com.wowls.sff.controller"))
	                .build()
	                .apiInfo(apiInfo())
	                .useDefaultResponseMessages(true);
	    }
	     
	    private ApiInfo apiInfo() {
	        return new ApiInfoBuilder()
	            .title("SFF Rest API")
	            .description("by woo soo keun")
	            .version("1.0.0")
//	            .licenseUrl("n/a")
	            .contact("dntnrmsss@naver.com")
	            .build();
	    }

}
