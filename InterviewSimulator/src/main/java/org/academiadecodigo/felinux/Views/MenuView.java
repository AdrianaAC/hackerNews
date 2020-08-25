package org.academiadecodigo.felinux.Views;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.felinux.Controllers.MenuController;
import org.academiadecodigo.felinux.PlayerHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Shows the client logIn, asks the name of the client
 */
public class MenuView extends AbstractView {

    private Prompt prompt;
    String answerOption;

    private PlayerHandler playerHandler;
    private GameView gameView;
    private MenuController menuController;

    public MenuView(PlayerHandler playerHandler, GameView menuView) {
        this.playerHandler = playerHandler;
        this.gameView = menuView;
        menuController = new MenuController(this,playerHandler, menuView);
    }


    @Override
    public void show() {
        try {
            finalMenu(playerHandler.getIn(), playerHandler.getOut());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void finalMenu(BufferedReader in, PrintWriter out) throws IOException {

        String choseOptionMenu= "Please choose one of the options:\n";
        String option1 = "1 - Restart Interview\n";
        String option2 = "2 - Forget Java and get a job in Pizza Hut\n";

        out.write(choseOptionMenu);
        out.write(option1);
        out.write(option2);
        out.write(this.playerHandler.getPlayer().getName() + ": ");
        out.flush();
        answerOption = in.readLine();
        menuController.check(playerHandler.getIn(), playerHandler.getOut(),4);

    }

    public String getAnswerOption() {
        return answerOption;
    }
}

