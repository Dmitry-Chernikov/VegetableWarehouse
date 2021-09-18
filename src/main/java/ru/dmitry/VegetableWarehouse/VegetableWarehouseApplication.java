package ru.dmitry.VegetableWarehouse;

import com.example.grpc.ServiceGrpc;
import com.example.grpc.UnitsServiceRpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.dmitry.VegetableWarehouse.serverGrpc.UnitsServiceImpl;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.io.IOException;

@SpringBootApplication
public class VegetableWarehouseApplication {

	public static void main(String[] args) throws IOException, InterruptedException {
		SpringApplication.run(VegetableWarehouseApplication.class, args);

/*		Server server = ServerBuilder.forPort(9090)
				.addService(new UnitsServiceImpl())
				.build();
		server.start();
		System.out.println("Server started");
		server.awaitTermination();*/

/*		ManagedChannel channel = ManagedChannelBuilder.forTarget("localhost:9090")
				.usePlaintext().build();
		ServiceGrpc.ServiceBlockingStub stub =
				ServiceGrpc.newBlockingStub(channel);
		UnitsServiceRpc.Request request = UnitsServiceRpc.Request
				.newBuilder().setName("Dima").build();

		UnitsServiceRpc.Response response = stub.getAllUnits(request);

		System.out.println(response);
		channel.shutdownNow();*/

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

	/*@Bean
	public GrpcServerConfigurer keepAliveServerConfigurer() {
		return serverBuilder -> {
			if (serverBuilder instanceof NettyServerBuilder) {
				((NettyServerBuilder) serverBuilder)
						.keepAliveTime(30, TimeUnit.SECONDS)
						.keepAliveTimeout(5, TimeUnit.SECONDS)
						.permitKeepAliveWithoutCalls(true);
			}
		};
	}*/




/*	@Bean
	public CommandLineRunner commandLineRunner(ApiListingContext ctx){
		return args -> {
			System.out.println("Все бины");
			Arrays.stream(ctx.getBeanDefinionNames()).sorted().forEach(System.out::println);
		};
	}*/
}
