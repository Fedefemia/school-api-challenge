package com.scuola.apichallenge.grpc.server;
import com.scuola.apichallenge.grpc.Empty;
import com.scuola.apichallenge.grpc.FilmList;
import com.scuola.apichallenge.grpc.FilmMessage;
import com.scuola.apichallenge.grpc.FilmServiceGrpc;
import io.grpc.stub.StreamObserver;
public class GrpcFilmServiceImpl extends FilmServiceGrpc.FilmServiceImplBase {
    @Override
    public void getFilms(Empty request, StreamObserver<FilmList> responseObserver) {
        FilmList response = FilmList.newBuilder()
                .addFilms(FilmMessage.newBuilder().setId("1").setTitolo("Il Padrino").setAnno(1972).setRegista("Francis Ford Coppola").build())
                .addFilms(FilmMessage.newBuilder().setId("2").setTitolo("Pulp Fiction").setAnno(1994).setRegista("Quentin Tarantino").build())
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
