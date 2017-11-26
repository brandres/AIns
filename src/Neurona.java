import java.io.Serializable;
import java.util.ArrayList;

public class Neurona extends Thread implements Serializable {
    ArrayList<Neurona> conectadas;
    public Neurona(){
        conectadas = new ArrayList<Neurona>();
    }

    public Neurona(ArrayList<Neurona> n){
        conectadas = n;
    }

    public ArrayList<Neurona> getConectadas() {
        return conectadas;
    }

    public void conectarCon(Neurona n) {
        conectadas.add(n);
        n.conectadas.add(this);
    }
    public boolean desconectar(Neurona n){
        return conectadas.remove(n);
    }

    @Override
    public void run() {
        while(true){
            try {
                sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String toString() {
        String res = "";
        res = "Neurona: " + getId();
        return res;
    }
}
