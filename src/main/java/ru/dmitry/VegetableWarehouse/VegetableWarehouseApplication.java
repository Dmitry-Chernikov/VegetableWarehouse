package ru.dmitry.VegetableWarehouse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class VegetableWarehouseApplication {
	public static void main(String[] args) {
		SpringApplication.run(VegetableWarehouseApplication.class, args);

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		TestSpring vwa = context.getBean("testSpring", TestSpring.class);
		System.out.println(vwa.getName());
		context.close();
	}

}


