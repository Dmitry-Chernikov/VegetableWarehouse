package ru.dmitry.VegetableWarehouse.serverGrpc;

import com.example.grpc.ServiceGrpc;
import com.example.grpc.UnitsServiceRpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class UnitsServiceImpl extends ServiceGrpc.ServiceImplBase {
    @Override
    public void getAllUnits(UnitsServiceRpc.Request request,
                            StreamObserver<UnitsServiceRpc.Response> responseObserver) {
        System.out.println(request);
        UnitsServiceRpc.Response response = UnitsServiceRpc.Response.newBuilder()
                .setGreeting("Hello from server, " + request.getName())
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

}
