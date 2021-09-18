package ru.dmitry.VegetableWarehouse.clientGrpc;

import com.example.grpc.ServiceGrpc;
import com.example.grpc.UnitsServiceRpc;
import io.grpc.StatusRuntimeException;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class UnitsClientService {
    @GrpcClient("myServiceClient")
    private ServiceGrpc.ServiceBlockingStub serviceGrpc;

    public String sendMessage(final String name) {
        try {
            final UnitsServiceRpc.Response response = this.serviceGrpc.getAllUnits(UnitsServiceRpc.Request.newBuilder().setName(name).build());
            return response.getGreeting();
        } catch (final StatusRuntimeException e) {
            return "FAILED with " + e.getStatus().getCode().name();
        }
    }
}
