package ru.dmitry.VegetableWarehouse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@SpringBootApplication
public class VegetableWarehouseApplication {

	public static void main(String[] args) {
		SpringApplication.run(VegetableWarehouseApplication.class, args);
	}

	@Bean
	public Docket api(){
		return new Docket(DocumentationType.SWAGGER_2)
				.enable(true)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build();
	}




/*	@Bean
	public CommandLineRunner commandLineRunner(ApiListingContext ctx){
		return args -> {
			System.out.println("Все бины");
			Arrays.stream(ctx.getBeanDefinionNames()).sorted().forEach(System.out::println);
		};
	}*/
}
