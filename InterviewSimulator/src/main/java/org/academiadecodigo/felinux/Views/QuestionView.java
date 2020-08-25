package org.academiadecodigo.felinux.Views;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.felinux.Controllers.QuestionsController;
import org.academiadecodigo.felinux.PlayerHandler;

import java.io.PrintWriter;

/**
 * Ask the question
 */
public class QuestionView extends AbstractView {

    private Prompt prompt;
    private PlayerHandler playerHandler;
    private GameView menuView;
    private QuestionsController questionsController;
    private static long startTime;
    private static long elapsedTime;
    private static long elapsedDisplay;
    private static long secondsDisplay;
    private static long averageTime;
    private static long endTime;



    public QuestionView(PlayerHandler playerHandler, GameView menuView, QuestionsController questionsController) {

        this.prompt = new Prompt(System.in, System.out);
        this.playerHandler = playerHandler;
        this.menuView = menuView;
        this.questionsController = new QuestionsController(this.playerHandler, this);
    }


    @Override
    public void show() {
        showQuestions(playerHandler.getOut());
    }

    public void showQuestions(PrintWriter out) {


        try {
            for (int i = 0; i < Question.values().length; i++) {
                if (i == 0) {
                    out.write(Message.FISRTQUESTION);
                    out.flush();
                    menuView.askQuestion(playerHandler.getOut(), i);
                    questionsController.check(playerHandler.getIn(), playerHandler.getOut(), i);
                    Thread.sleep(1800);
                    continue;
                }
                out.write("- QUESTION " + (i + 1) + "\n");
                out.flush();
                menuView.askQuestion(playerHandler.getOut(), i);
                questionsController.check(playerHandler.getIn(), playerHandler.getOut(), i);
                Thread.sleep(1800);
            }

            Thread.sleep(1800);
            menuView.endGAme(playerHandler.getOut());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void startTimer() {
        startTime = System.currentTimeMillis();

    }

    public static void endTimer () {
        endTime = System.currentTimeMillis();

    }

    public static void calculateTime(PrintWriter out) {

        System.out.println(endTime);
        System.out.println(startTime);
        secondsDisplay = (endTime - startTime) / 1000;


        averageTime = secondsDisplay/ (Question.values().length);
       out.write("This interview lasted " + secondsDisplay + " seconds\n");
       out.write("Average time per answer:  "+ averageTime +" seconds \n");


        out.write("\n");
        out.write("\n");
        out.write("\n");
        out.flush();

    }







    public void setSecondsDisplay(long secondsDisplay) {
        this.secondsDisplay = secondsDisplay;
    }


}
