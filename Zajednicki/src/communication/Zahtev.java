package communication;

import java.io.Serializable;

public class Zahtev implements Serializable {

    private Operacija operacija;
    private Object argument;

    public Zahtev() {
    }

    public Zahtev(Operacija operacija, Object argument) {
        this.operacija = operacija;
        this.argument = argument;
    }

    public Operacija getOperacija() {
        return operacija;
    }

    public void setOperacija(Operacija operacija) {
        this.operacija = operacija;
    }

    public Object getArgument() {
        return argument;
    }

    public void setArgument(Object argument) {
        this.argument = argument;
    }
}
