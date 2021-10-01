package ru.dmitry.VegetableWarehouse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.io.IOException;
import java.util.Collections;

@EnableSwagger2
//@EnableSwagger2WebMvc
@Import(SpringDataRestConfiguration.class)
@Configuration
@SpringBootApplication
public class VegetableWarehouseApplication {

	public static void main(String[] args) throws IOException, InterruptedException {
		SpringApplication.run(VegetableWarehouseApplication.class, args);
	}

	@Bean
	public Docket api(){
		return new Docket(DocumentationType.SWAGGER_2)
				.enable(true)
				.select()
				.apis(RequestHandlerSelectors.basePackage("ru.dmitry.VegetableWarehouse.controllers"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(apiInfo());
	}


	private ApiInfo apiInfo() {
		return new ApiInfo(
				"REST API Овощебаза",
				"Some custom description of API.",
				"1.0",
				"http://www.apache.org/licenses/LICENSE-2.0",
				new Contact("Dmitry Chernikov", "www.example.com", "myeaddress@company.com"),
				"Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0", Collections.emptyList());
	}

/*	@Bean
	public CommandLineRunner commandLineRunner(ApiListingContext ctx){
		return args -> {
			System.out.println("Все бины");
			Arrays.stream(ctx.getBeanDefinionNames()).sorted().forEach(System.out::println);
		};
	}*/
}
