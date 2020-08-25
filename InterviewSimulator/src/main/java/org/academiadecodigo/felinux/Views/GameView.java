package org.academiadecodigo.felinux.Views;


import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.felinux.Controllers.QuestionsController;
import org.academiadecodigo.felinux.Models.Player;
import org.academiadecodigo.felinux.PlayerHandler;
import org.academiadecodigo.felinux.Server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * Are you ready message. Countdown??
 */
public class GameView extends AbstractView {

    private Prompt prompt;
    private BufferedWriter out;
    private BufferedReader in;
    private Server server;
    private Player player;
    private PlayerHandler playerHandler;
    private QuestionView questionView;
    private QuestionsController questionsController;
    private MenuView menuView;


    public GameView(PlayerHandler playerHandler) {
        this.prompt = new Prompt(System.in, System.out);
        this.playerHandler = playerHandler;
        this.questionView = new QuestionView(this.playerHandler, this, this.questionsController);
        this.menuView = new MenuView(this.playerHandler, this);

    }

    @Override
    public void show() {

        try {

            welcome(playerHandler.getOut());
            Thread.sleep(2500);
            askName(playerHandler.getIn(), playerHandler.getOut());
            interviewWelcome(playerHandler.getOut());
            Thread.sleep(2500);
            QuestionView.startTimer();
            questionView.show();
            playerHandler.checkScore(playerHandler.getOut());
            Thread.sleep(2500);
            menuView.show();
            Thread.sleep(2500);


        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    public void askName(BufferedReader in, PrintWriter out) {


        try {
            String name;
            out.write(Message.USERNAME);

            out.write("\n Enter name: ");
            out.flush();
            name = in.readLine();

            while (name.isEmpty()) {

                out.write("** That is not a valid name, try again please. **");
                out.write("\n Enter name: ");
                out.flush();
                name = in.readLine();
                this.playerHandler.getPlayer().setName(name);

            }

            this.playerHandler.getPlayer().setName(name);

        } catch (IOException exception) {
            exception.getMessage();
        }
    }

    public void askQuestion(PrintWriter out, int questionNum) {

        out.write(Question.values()[questionNum].getQuestion());
        out.flush();

    }

    public void endGAme(PrintWriter out) {
        out.write(Message.INTERVIEWFINISHED);
        out.flush();

    }

    public void welcome(PrintWriter out) {
        out.write(Message.INTERVIEWSIMULATOR);
        out.flush();
    }

    public void interviewWelcome(PrintWriter out) {

        try {

            out.write(Message.GETREADY + playerHandler.getPlayer().getName() + "!");
            out.flush();
            Thread.sleep(2000);
            out.write(Message.LETSGO);
            out.flush();

        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
    }
}

