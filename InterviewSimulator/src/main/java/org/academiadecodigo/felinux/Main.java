package org.academiadecodigo.felinux;

import org.academiadecodigo.felinux.Views.Question;

import javax.swing.*;
import java.awt.*;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Main {

    JFrame theFrame;
    JPanel mainPanel;
    String player;
    ObjectOutputStream out;
    ObjectInputStream in;

    public static void main(String[] args) {
        System.out.println("Enter your username: ");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        System.out.println("Your username is " + username);
        new Main().buildUI();
        Server server = new Server(8000);
        server.start();

    }


    private void buildUI() {

        JFrame frame = new JFrame("<AC_> Interview Simulator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = frame.getContentPane();
// add buttons
        JPanel buttonsPanel = new JPanel();
        leftButton = new JButton(Question.QUESTION1.getCorrectAnswer());
        leftButton.addActionListener(btnsListener);
        buttonsPanel.add(leftButton, BorderLayout.LINE_START);
        restartButton = new JButton("Start");
        restartButton.addActionListener(btnsListener);
        buttonsPanel.add(restartButton, BorderLayout.LINE_START);
        noButton = new JButton("No");
        noButton.addActionListener(btnsListener);
        buttonsPanel.add(noButton, BorderLayout.LINE_END);
        contentPane.add(buttonsPanel, BorderLayout.PAGE_END);
// add text area
        textPane = new JTextPane();
        textPane.setEditable(false);
        updateText("Think to an animal, then click on Start");
// we define some style for the text pane
        SimpleAttributeSet bSet = new SimpleAttributeSet();
        StyleConstants.setAlignment(bSet, StyleConstants.ALIGN_CENTER);
        StyleConstants.setFontSize(bSet, 22);
        StyledDocument doc = textPane.getStyledDocument();
        doc.setParagraphAttributes(0, doc.getLength(), bSet, false);
        contentPane.add(textPane, BorderLayout.CENTER);
        frame.setMinimumSize(new Dimension(500, 250));
// we center the JFrame
        Dimension objDimension = Toolkit.getDefaultToolkit().getScreenSize();
        int coordX = (objDimension.width - frame.getWidth()) / 2;
        int coordY = (objDimension.height - frame.getHeight()) / 2;
        frame.setLocation(coordX, coordY);
// we display the window
        frame.pack();
        frame.setVisible(true);
    }



    /*public void startUp(String player) {

        try {
            Socket socket = new Socket("127.0.0.1", 8000);
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());
            Thread remote = new Thread(new RemoteReader());
            remote.start();
        } catch (Exception ex) {
            System.out.println("Couldn't connect to the multigame, you'll have to pretend to have some friends instead");
        }
        buildTheGui();
    }*/

    public void buildTheGui() {
        /*theFrame = new JFrame("Interview Simulator/n" + "Interviewing " + player);
        theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BorderLayout layout = new BorderLayout();
        JPanel background = new JPanel(layout);
        background.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        //checkBoxArrayList = new ArrayList<JCheckBox>();
        Box buttonBox = new Box(BoxLayout.Y_AXIS);
        JButton start = new JButton("Start Game");
        //start.addActionListener(new MyStartListener());
        buttonBox.add(start);
        theFrame.getContentPane().add(background);
        theFrame.setBounds(50, 50, 300, 300);
        theFrame.pack();
        theFrame.setVisible(true);*/


        theFrame = new JFrame("Interview Simulator/n" + "Interviewing " + player);
        theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BorderLayout layout = new BorderLayout();
        JPanel background = new JPanel(layout);
        background.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        //checkBoxArrayList = new ArrayList<JCheckBox>();

        Box buttonBox = new Box(BoxLayout.Y_AXIS);
        JButton start = new JButton("Start");
        //start.addActionListener(new MyStartListener());
        buttonBox.add(start);

        JButton stop = new JButton("Stop");
        //stop.addActionListener(new MyStopListener());
        buttonBox.add(stop);

        JButton upTempo = new JButton("Tempo UP");
        //upTempo.addActionListener(new MyUpTempoListener());
        buttonBox.add(upTempo);

        JButton downTempo = new JButton("Tempo DOWN");
        //downTempo.addActionListener(new MyDownTempoListener());
        buttonBox.add(downTempo);

        JButton clear = new JButton("Clear");
        //clear.addActionListener(new MyClearListener());
        buttonBox.add(clear);

        JButton sendIt = new JButton("Send message");
        //sendIt.addActionListener(new MySendListener());
        buttonBox.add(sendIt);

        //userMessage = new JTextField();
        //buttonBox.add(userMessage);

        //incomingList = new JList();
        //incomingList.addListSelectionListener(new MyListSelectionListener());
        //incomingList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //JScrollPane theList = new JScrollPane(incomingList);
        // buttonBox.add(theList);
        //incomingList.setListData(listVector);

        Box nameBox = new Box(BoxLayout.Y_AXIS);
        for (int i = 0; i < 16; i++) {
            // nameBox.add(new Label(instrumentNames[i]));
        }

        background.add(BorderLayout.EAST, buttonBox);
        background.add(BorderLayout.WEST, nameBox);

        theFrame.getContentPane().add(background);

        GridLayout grid = new GridLayout(16, 16);
        grid.setVgap(1);
        grid.setHgap(2);
        //mainPanel = new JPanel(grid);
        background.add(BorderLayout.CENTER,mainPanel);


        for (int i = 0; i < 256; i++) {
            JCheckBox checkBox = new JCheckBox();
            checkBox.setSelected(false);
            //checkBoxArrayList.add(checkBox);
            //mainPanel.add(checkBox);
        }

        theFrame.setBounds(50, 50, 300, 300);
        theFrame.pack();
        theFrame.setVisible(true);
    }
}

