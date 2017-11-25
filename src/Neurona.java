import java.io.Serializable;
import java.util.ArrayList;

public class Neurona extends Thread implements Serializable {
    ArrayList<Neurona> conectadas;

    public void conectarCon(Neurona n) {
        conectadas.add(n);
    }
    public boolean desconectar(Neurona n){
        return conectadas.remove(n);
    }

    @Override
    public void run() {
        while(true){
            System.out.println(getId());
            try {
                sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
