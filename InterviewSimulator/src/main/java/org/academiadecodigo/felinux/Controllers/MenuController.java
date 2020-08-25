package org.academiadecodigo.felinux.Controllers;

import org.academiadecodigo.felinux.PlayerHandler;
import org.academiadecodigo.felinux.Views.GameView;
import org.academiadecodigo.felinux.Views.MenuView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class MenuController implements Controller {
    private MenuView menuView;
    private PlayerHandler playerHandler;
    private GameView gameView;

    public MenuController(MenuView menuView, PlayerHandler playerHandler, GameView gameView) {
        this.menuView = menuView;
        this.playerHandler = playerHandler;
        this.gameView = gameView;
    }

    @Override
    public void check(BufferedReader in, PrintWriter out, int answerNum) {

        if (!menuView.getAnswerOption().equals("1") && !menuView.getAnswerOption().equals("2")) {
            try {
                out.write("Not Valid Option\n");
                out.flush();
                menuView.finalMenu(playerHandler.getIn(), playerHandler.getOut());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (menuView.getAnswerOption().equals("1")) {
            out.write("Let's Try Again");
            out.flush();
            playerHandler.getPlayer().setScore(0);
            System.out.println("Sim");
            gameView.show();
        }
        if (menuView.getAnswerOption().equals("2")) {
            try {
                out.write("Bye Bye");
                playerHandler.getOut().close();
                playerHandler.getIn().close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


}
