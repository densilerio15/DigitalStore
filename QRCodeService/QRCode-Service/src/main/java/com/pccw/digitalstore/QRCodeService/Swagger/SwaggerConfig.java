package com.pccw.digitalstore.QRCodeService.Swagger;

import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

public class SwaggerConfig{
	
	@Bean
	public Docket api() {
		return  new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("org.baeldung.web.controller"))
				.paths(PathSelectors.ant("/QRCode/*"))                  
				.build();
	}

	private ApiInfo getApiInfo() {
		Contact contact = new Contact("PCCW", "http://blog.PCCW.com", "PCCW@pccw.com");
		return new ApiInfoBuilder()
				.title("Digital Store API")
				.description("Digital Store example API")
				.version("1.0")
				.license("Apache 2.0")
				.licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")
				.contact(contact)
				.build();
	}

}