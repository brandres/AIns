import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;

public class Neurona extends Thread implements Serializable {
    ArrayList<Neurona> conectadas;
    public ArrayList<Entrada> entradas ;
    public int salida;
    public int estadoEntradas;
    public Neurona(){
        conectadas = new ArrayList<Neurona>();
        entradas = new ArrayList<Entrada>();
        salida = 0;
        estadoEntradas = 0;
    }

    public Neurona(ArrayList<Neurona> n){
        conectadas = n;
    }

    public ArrayList<Neurona> getConectadas() {
        return conectadas;
    }

    public void conectarCon(Neurona n) {
        conectadas.add(n);
        entradas.add(new Entrada(n.salida,0,n.getId()));
        n.conectadas.add(this);
    }
    public boolean desconectar(Neurona n){
        eliminarEntrada(n.getId());
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
                int res = 0;
                if(entradas.size() > 0){
                    for(Entrada n : entradas){
                        if(estadoEntradas == 2){
                            cambiarCalculo(n);
                            estadoEntradas = 0;
                        }
                        fos.write(this.toString() + ": " + n.calculo + "\n");
                        res = procesarEntrada(n.getEntrada(),res,n.getCalculo());
                    }
                    salida = res;
                }

                    pw.print("");
                    pw.flush();
                    //fos.write(this.toString() + ": " + getConectadas().toString() + "\n");
                    Thread.sleep(1);
            }
        }catch (Exception e){
            System.out.println(e.getStackTrace());
        }

    }

    @Override
    public String toString() {
        String res = "";
        res = "Neurona-" + getId();
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
        return 0;

    }
    public void eliminarEntrada(long id){
        for(Entrada e : entradas){
            if(e.id == id){
                entradas.remove(e);
            }
        }
    }
    public void addEntradaExterna(int valor,long id){
        entradas.add(new Entrada(0,valor,id));
    }
    public void cambiarCalculo(Entrada e){
        if(e.calculo == 6){
            e.calculo = 1;
        }else{
            e.calculo += 1;
        }
    }
}
