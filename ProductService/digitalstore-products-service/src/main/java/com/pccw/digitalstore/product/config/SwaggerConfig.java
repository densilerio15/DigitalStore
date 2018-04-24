package com.pccw.digitalstore.product.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
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
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.regex("/product.*"))
				.build()
			.apiInfo(getApiInfo());
	}
	
	private ApiInfo getApiInfo() {
		Contact contact = new Contact("PCCW", "http://digitalstore.pccw.com", "pccw@pccw.com");
		return new ApiInfoBuilder()
				.title("Product Service API")
				.description("Contains all the processes involved with products")
				.version("v1")
				.contact(contact)
				.build();
	}

}
