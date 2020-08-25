package org.academiadecodigo.felinux.Views;

/**
 * all the questions from the game
 */
public enum Question {

    QUESTION1("\n- What year was JAVA created ?\n", "1991"),
    QUESTION2("\n- What type of pattern is the state design pattern ?\n", "behavioural"),
    QUESTION3("\n- Integer is what, to a int variable ?\n", "wrapper"),
    QUESTION4("\n- What does MVC stands for ?\n", "model view controller"),
    QUESTION5("\n - What does JVM stand for?\n", "java virtual machine"),
    QUESTION6("\n - What's the name of the local where objects are stored?\n", "heap"),
    QUESTION7("\n - There are four access modifiers in java. Name them in security order from most secure to least secure:\n", "private protected default public"),
    QUESTION8("\n - There are 4 main bases in OOP. Name them:\n", "inheritance encapsulation abstraction polymorphism"),
    QUESTION9("\n - All methods have return type, including void. True or false?\n", "false"),
    QUESTION10("\n - Can you overwrite a private or static method?\n", "no"),
    QUESTION11("\n - What does OOP stands for?\n", "object oriented programming"),
    QUESTION12("\n - What's the default value of a string?\n", "null"),
    QUESTION13("\n - 'public final constructors makes the instance  resulting of it not changeable'. True or false?\n","false"),
    QUESTION14("\n - Name the two things that give a object 'its personality'\n", "state behaviour"),
    QUESTION15("\n - Are abstraction and encapsulation the same thing?\n", "no");



    private String question;
    private String correctAnswer;
    private int questionNum;

    Question(String question, String correctAnswer) {
        this.correctAnswer = correctAnswer;
        this.question = question;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

}