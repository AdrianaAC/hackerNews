import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

public class BeatBoxServer {
    ArrayList<ObjectOutputStream> clientOutputStreams;

    public static void main(String[] args) {
        new BeatBoxServer().go();
    }

    public class ClientHandler implements Runnable {
        ObjectInputStream in;
        Socket clientSocket;

        public ClientHandler(Socket socket) {
            try {
                clientSocket = socket;
                in = new ObjectInputStream(clientSocket.getInputStream());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        public void run () {
            Object o2 = null;
            Object o1 = null;

            try {
                while((o1=in.readObject()) != null) {
                    o2= in.readObject();
                    System.out.println("read two objects");
                    tellEveryone(o1, o2);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    public void go(){
        clientOutputStreams = new ArrayList<ObjectOutputStream>();
        try {
            ServerSocket serverSocket = new ServerSocket(4242);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
                clientOutputStreams.add(out);

                Thread thread = new Thread(new ClientHandler(clientSocket));
                thread.start();

                System.out.println("Got a connection!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void tellEveryone(Object one, Object two) {
        Iterator iterator = clientOutputStreams.iterator();

        while(iterator.hasNext()) {
            try {
                ObjectOutputStream out = (ObjectOutputStream) iterator.next();
                out.writeObject(one);
                out.writeObject(two);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}

