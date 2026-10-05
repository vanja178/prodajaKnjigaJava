package communication;

import java.io.ObjectInputStream;
import java.net.Socket;

public class Primalac {

    private final Socket socket;

    public Primalac(Socket socket) {
        this.socket = socket;
    }

    public Object primi() throws Exception {
        ObjectInputStream in;
        try {
            in = new ObjectInputStream(socket.getInputStream());
            return in.readObject();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception("Greska kod citanja objekta: " + ex.getMessage());
        }
    }
}
