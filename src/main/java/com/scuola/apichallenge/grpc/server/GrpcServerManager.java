package com.scuola.apichallenge.grpc.server;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import java.io.IOException;
@Component
public class GrpcServerManager {
    private Server server;
    @PostConstruct
    public void start() throws IOException {
        server = ServerBuilder.forPort(9090).addService(new GrpcFilmServiceImpl()).build().start();
    }
    @PreDestroy
    public void stop() {
        if (server != null) server.shutdown();
    }
}
