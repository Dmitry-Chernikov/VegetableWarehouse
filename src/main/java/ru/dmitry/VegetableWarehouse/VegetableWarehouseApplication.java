package ru.dmitry.VegetableWarehouse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class VegetableWarehouseApplication {
	public static void main(String[] args) {
		SpringApplication.run(VegetableWarehouseApplication.class, args);

//		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
//				"applicationContext.xml"
//		);
//
//		TestBean testBean = context.getBean("testBean", TestBean.class);
//		System.out.println(testBean.getName());
//		context.close();
	}

}


