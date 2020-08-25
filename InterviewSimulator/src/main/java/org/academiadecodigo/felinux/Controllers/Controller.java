package org.academiadecodigo.felinux.Controllers;

import java.io.BufferedReader;
import java.io.PrintWriter;

public interface Controller {

    public void check (BufferedReader in, PrintWriter out, int answerNum);
}
