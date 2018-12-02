import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;

public class Neurona extends Thread implements Serializable {
    ArrayList<Neurona> conectadas;
    public ArrayList<Integer> entradas ;
    public int salida;
    public int var;
    public ArrayList<Integer> calculos;
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
        FileWriter fos;
        PrintWriter pw;
        try{
            fos = new FileWriter("neuronas.log");
            pw = new PrintWriter("neuronas.log");
            while(true){
                if(getConectadas().size() > 0){
                    int res = 0;
                    for(int n : entradas){
                        res = procesarEntrada(n,res,);
                    }
                }
                    salida = procesarEntrada();
                    pw.print("");
                    pw.flush();
                    fos.write(this.toString() + ": " + getConectadas().toString() + "\n");
                    Thread.sleep(1);
            }
        }catch (Exception e){
            System.out.println(e.getStackTrace());
        }

    }

    @Override
    public String toString() {
        String res = "";
        res = "Neurona-" + getId() + "(" + var  + "-" + calculo +")";
        return res;
    }
    public int procesarEntrada(int e, int res,int calculo){
        switch (calculo){
            case 1: return e * res;
            case 2: return e + res;
            case 3: return e / res;
            case 4: return res / e;
            case 5: return e - res;
            case 6: return res - e;
        }

    }
}
