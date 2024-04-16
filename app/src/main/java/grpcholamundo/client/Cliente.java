package grpcholamundo.client;

import com.proto.saludo.GreetingServiceGrpc;
import com.proto.saludo.Holamundo.GreetingRequest;
import com.proto.saludo.Holamundo.GreetingResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class Cliente {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 8080;

        ManagedChannel managedChannel = ManagedChannelBuilder
        .forAddress(host, port)
        .usePlaintext()
        .build();

        GreetingServiceGrpc.GreetingServiceBlockingStub stub = GreetingServiceGrpc.newBlockingStub(managedChannel);
        GreetingRequest request = GreetingRequest.newBuilder().setName("Rodrigo").build();
        GreetingResponse response = stub.greeting(request);

        System.out.println("Respuesta RPC: " + response.getResult());
        System.out.println("Apagando...");
        managedChannel.shutdown();
    }
}


