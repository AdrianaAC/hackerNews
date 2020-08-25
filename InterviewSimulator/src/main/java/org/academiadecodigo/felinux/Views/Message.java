package org.academiadecodigo.felinux.Views;




/**
 * All the messages
 */
public class Message {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public final static String INTERVIEWSIMULATOR =
          "\n___   __    _  _______  _______  ______    __   __  ___   _______  _     _" +
         "\n|   | |  |  | ||       ||       ||    _ |  |  | |  ||   | |       || | _ | |" +
         "\n|   | |   |_| ||_     _||    ___||   | ||  |  |_|  ||   | |    ___|| || || |" +
         "\n|   | |       |  |   |  |   |___ |   |_||_ |       ||   | |   |___ |       |" +
         "\n|   | |  _    |  |   |  |    ___||    __  ||       ||   | |    ___||       |" +
         "\n|   | | | |   |  |   |  |   |___ |   |  | | |     | |   | |   |___ |   _   |" +
         "\n|___| |_|  |__|  |___|  |_______||___|  |_|  |___|  |___| |_______||__| |__|\n\n"+
        "\n_______  ___   __   __  __   __  ___      _______  _______  _______  ______"+
       "\n|       ||   | |  |_|  ||  | |  ||   |    |   _   ||       ||       ||    _ |"+
       "\n|  _____||   | |       ||  | |  ||   |    |  |_|  ||_     _||   _   ||   | ||"+
       "\n| |_____ |   | |       ||  |_|  ||   |    |       |  |   |  |  | |  ||   |_||_"+
       "\n|_____  ||   | |       ||       ||   |___ |       |  |   |  |  |_|  ||    __  |"+
       "\n _____| ||   | | ||_|| ||       ||       ||   _   |  |   |  |       ||   |  | |"+
       "\n|_______||___| |_|   |_||_______||_______||__| |__|  |___|  |_______||___|  |_|\n\n";







    public final static String USERNAME = "\nPlease, enter your name:\n";

    public final static String WELCOME = "Welcome to your interview emulator. Let's see if you are ready for your coding interview!\n";

    public final static String INTERVIEWFINISHED = "Your interview has finished!\n";

    public final static String WRONGANSWER = " \n ** SORRY, THAT IS NOT THE CORRECT ANSWER!** \n" + "You stay with the same points \n";

    public final static String FISRTQUESTION = "\n - FIRST QUESTION - \n";


    public final static String GETREADY = "\n Alright, welcome to Interview Simulator, hope you're ready\n ";

    public final static String LETSGO = "\n Lets get started!\n \n";

    public final static String CORRECT = ANSI_GREEN + "\n" +

            "  / ____/  ____    _____   _____  ___   _____  / /_   / /\n" +
            " / /      / __ \\  / ___/  / ___/ / _ \\ / ___/ / __/  / / \n" +
            "/ /___   / /_/ / / /     / /    /  __// /__  / /_   /_/  \n" +
            "\\____/   \\____/ /_/     /_/     \\___/ \\___/  \\__/  (_)   \n" + ANSI_RESET;

    public final static String INCORRECT = ANSI_RED + "\n" +

            "   /  _/   ____   _____  ____    _____   _____  ___   _____  / /_   / /\n" +
            "   / /    / __ \\ / ___/ / __ \\  / ___/  / ___/ / _ \\ / ___/ / __/  / / \n" +
            " _/ /    / / / // /__  / /_/ / / /     / /    /  __// /__  / /_   /_/  \n" +
            "/___/   /_/ /_/ \\___/  \\____/ /_/     /_/     \\___/ \\___/  \\__/  (_)   \n" + ANSI_RESET;

    public final static String APPROVED = ANSI_GREEN + "\n" +
            "   /   |    ____     ____    _____  ____  _   __  ___   ____/ /   / /\n" +
            "  / /| |   / __ \\   / __ \\  / ___/ / __ \\| | / / / _ \\ / __  /   / / \n" +
            " / ___ |  / /_/ /  / /_/ / / /    / /_/ /| |/ / /  __// /_/ /   /_/  \n" +
            "/_/  |_| / .___/  / .___/ /_/     \\____/ |___/  \\___/ \\__,_/   (_)   \n" +
            "        /_/      /_/ \n" + "\n\n" + ANSI_RESET;

    public final static String NOTAPPROVED = ANSI_RED + "\n" +
            "   / | / /  ____   / /_          /   |    ____     ____    _____  ____  _   __  ___   ____/ /   / /\n" +
            "  /  |/ /  / __ \\ / __/         / /| |   / __ \\   / __ \\  / ___/ / __ \\| | / / / _ \\ / __  /   / / \n" +
            " / /|  /  / /_/ // /_          / ___ |  / /_/ /  / /_/ / / /    / /_/ /| |/ / /  __// /_/ /   /_/  \n" +
            "/_/ |_/   \\____/ \\__/         /_/  |_| / .___/  / .___/ /_/     \\____/ |___/  \\___/ \\__,_/   (_)   \n" +
            "                                      /_/      /_/  \n" + "\n\n" + ANSI_RESET;


}