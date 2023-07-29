package com.mca.game.server;

import com.mca.game.Die;
import com.mca.game.GameServiceGrpc;
import com.mca.game.GameState;
import com.mca.game.Player;
import io.grpc.stub.StreamObserver;

public class GameService extends GameServiceGrpc.GameServiceImplBase {

    @Override
    public StreamObserver<Die> roll(StreamObserver<GameState> responseObserver) {
        Player client = Player.newBuilder().setName("client").setPosition(0).build();
        Player server = Player.newBuilder().setName("server").setPosition(0).build();

        return new DieStreamingRequest(client, server, responseObserver);
    }
}
