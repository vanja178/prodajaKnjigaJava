package communication;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Posiljalac {

    private final Socket socket;

    public Posiljalac(Socket socket) {
        this.socket = socket;
    }

    public void posalji(Object objekat) throws Exception {
        try {
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(objekat);
            out.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new Exception("Greska kod slanja objekta: " + ex.getMessage());
        }
    }
}
