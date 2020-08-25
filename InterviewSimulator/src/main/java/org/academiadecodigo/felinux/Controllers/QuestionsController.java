package org.academiadecodigo.felinux.Controllers;

import org.academiadecodigo.felinux.PlayerHandler;
import org.academiadecodigo.felinux.Views.Message;
import org.academiadecodigo.felinux.Views.Question;
import org.academiadecodigo.felinux.Views.QuestionView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class QuestionsController implements Controller {

    private PlayerHandler playerHandler;
    private QuestionView questionView;

    public QuestionsController(PlayerHandler playerHandler, QuestionView questionView) {
        this.playerHandler = playerHandler;
        this.questionView = questionView;

    }

    public void check(BufferedReader in, PrintWriter out, int answerNum) {
        try {


            out.write(this.playerHandler.getPlayer().getName() + ": ");
            out.flush();
            String answer = in.readLine();

            while (answer.isEmpty()) {
                out.write("** That is not a valid answer, try again please. **\n");
                out.write(this.playerHandler.getPlayer().getName() + ": ");
                out.flush();
                answer = in.readLine();
            }



            if (Question.values()[answerNum] == Question.values()[7]) {

                if (answer.toLowerCase().contains("abstraction") && answer.toLowerCase().contains("inheritance") &&
                        answer.toLowerCase().contains("polymorphism") && answer.toLowerCase().contains("encapsulation")) {

                    this.playerHandler.getPlayer().setScore(this.playerHandler.getPlayer().getScore() + 1);
                    Thread.sleep(1000);
                    out.write("\n" + "** GREAT STUFF " + this.playerHandler.getPlayer().getName() + " your answer is: "
                            + "\n" + Message.CORRECT + "\n" + "You now have " + this.playerHandler.getPlayer().getScore() + " points! \n" + "\n");
                    //   questionView.displayTime(playerHandler.getOut());

                    out.flush();
                    return;

                }
            }

            if (Question.values()[answerNum].getCorrectAnswer().equals(answer.toLowerCase())) {

                this.playerHandler.getPlayer().setScore(this.playerHandler.getPlayer().getScore() + 1);
                Thread.sleep(1000);
                out.write("\n" + "** GREAT STUFF " + this.playerHandler.getPlayer().getName() + " your answer is: " + "\n" + Message.CORRECT + "\n" +
                        "You now have " + this.playerHandler.getPlayer().getScore() + " points! \n" + "\n");
                out.flush();
                return;
            }
            {


                out.write(Message.INCORRECT + "\n" + "You keep your " + this.playerHandler.getPlayer().getScore() + " points. \n");
                out.flush();

            }

        } catch (IOException | InterruptedException exception) {
            exception.printStackTrace();
        }
    }
}
