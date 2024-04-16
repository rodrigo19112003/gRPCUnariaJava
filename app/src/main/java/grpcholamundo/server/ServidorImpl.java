package grpcholamundo.server;

import com.proto.saludo.Holamundo.GreetingRequest;
import com.proto.saludo.Holamundo.GreetingResponse;
import com.proto.saludo.GreetingServiceGrpc;

import io.grpc.stub.StreamObserver;

public class ServidorImpl extends GreetingServiceGrpc.GreetingServiceImplBase {
    
    @Override
    public void greeting (GreetingRequest request, StreamObserver<GreetingResponse> responseObserver) {
        GreetingResponse response = GreetingResponse.newBuilder().setResult("Hola " + request.getName()).build();

        responseObserver.onNext(response);

        responseObserver.onCompleted();
    }
}


