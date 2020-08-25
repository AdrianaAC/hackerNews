package org.academiadecodigo.felinux;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PlayerHandler playerHandler;
    private ExecutorService pool = Executors.newCachedThreadPool();


    public Server(int port) {

        try {

          this.serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void start() {

        while (true) {

            try {

                this.clientSocket = serverSocket.accept();

                playerHandler = new PlayerHandler(clientSocket, this);

                pool.submit(playerHandler);


            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
    }
}
