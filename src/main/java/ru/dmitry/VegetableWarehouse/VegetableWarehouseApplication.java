package ru.dmitry.VegetableWarehouse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.io.IOException;
import java.time.LocalDate;

@EnableSwagger2
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
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build()
				.pathMapping("/swagger")
				.directModelSubstitute(LocalDate.class, String.class)
				.genericModelSubstitutes(ResponseEntity.class);
	}

/*	@Bean
	public CommandLineRunner commandLineRunner(ApiListingContext ctx){
		return args -> {
			System.out.println("Все бины");
			Arrays.stream(ctx.getBeanDefinionNames()).sorted().forEach(System.out::println);
		};
	}*/
}
