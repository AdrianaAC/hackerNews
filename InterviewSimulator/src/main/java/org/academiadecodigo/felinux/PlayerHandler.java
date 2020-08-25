package org.academiadecodigo.felinux;

import org.academiadecodigo.felinux.Models.Player;
import org.academiadecodigo.felinux.Views.*;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class PlayerHandler implements Runnable {

    private Scanner scanner;
    private Player player;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    private MenuView loginView;
    private Socket socket;
    private Server server;
    private GameView menuView;
    private String messageFromClient;
    private Question question;


    public PlayerHandler(Socket clientSocket, Server server) {

        player = new Player("");
        menuView = new GameView(this);
        this.clientSocket = clientSocket;
        this.server = server;

        try {
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new PrintWriter(clientSocket.getOutputStream(),true);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void run() {

        try {
            menuView.show();

            while (true) {
                messageFromClient = in.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Player getPlayer() {
        return player;
    }

    public BufferedReader getIn() {
        return in;
    }

    public PrintWriter getOut() {
        return out;
    }

    public void checkScore(PrintWriter out) {


        if (player.getScore() < 10) {

            out.write("\n" + Message.NOTAPPROVED + "\n\n\n" + "I'm sorry " + this.getPlayer().getName() +", " +
                    "but you didn't made the cut! You only answered correctly to " + this.getPlayer().getScore() +
                    " out of "   + Question.values().length + " questions.\n\n");
            QuestionView.endTimer();
            QuestionView.calculateTime(out);

            out.flush();
            return;
        }

        out.write( "\n" + Message.APPROVED + "\n\n\n" + "Welcome to our company " +  this.getPlayer().getName() +"." +
                " You answered correctly to " + this.getPlayer().getScore() + " out of " + Question.values().length + " questions.\n\n");
        QuestionView.endTimer();
        QuestionView.calculateTime(out);

        out.flush();

    }
}