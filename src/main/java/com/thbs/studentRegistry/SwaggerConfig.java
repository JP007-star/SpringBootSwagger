package com.thbs.studentRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    public final Logger LOG = LoggerFactory.getLogger(this.getClass());
    @Bean
    public Docket api() {
        LOG.info("Swagger initilized...");
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(abcd()).select().apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any()).build();
    }

    private ApiInfo abcd() {
        LOG.info("Api Info");
        return new ApiInfoBuilder().title("Student REST API Controller")
                .description("Student Rest API Controller")
                .contact(new Contact("Torry Harris", "torryharris.com", "jaya_muthukrishnan@thbs.com"))
                .license("Apache 2.0").version("1.0.0").build();
    }

    // more methods

}
