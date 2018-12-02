import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Cerebro {
    public static ArrayList<Neurona> neuronas;
    FileInputStream fos;
    public Cerebro() {
        try {
            load();
        } catch (Exception e) {
            neuronas = new ArrayList<Neurona>();
        }

        try {
            for (Neurona n : neuronas) {
                System.out.println(n);
                n.start();
            }
        } catch (NullPointerException err) {

        }

    }

    public void save() {
        try {
            FileOutputStream fos = new FileOutputStream("recuerdos.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(neuronas); // write MenuArray to ObjectOutputStream
            oos.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void load() throws Exception {
        fos = new FileInputStream("recuerdos.txt");
        ObjectInputStream input = new ObjectInputStream(fos);
        neuronas = (ArrayList<Neurona>) input.readObject();
        input.close();
    }

    public void añadirNeurona(Neurona n) {
        neuronas.add(n);
        n.start();
        save();
    }

    public void crearNeurona() {
        neuronas.add(new Neurona());
        neuronas.get(neuronas.size() - 1).start();
        save();
    }

    public static void main(String[] args) {
        Cerebro c = new Cerebro();
        while(true){
        System.out.println("Empezamos el programa");
        System.out.println("¿Que hacemos?");
        String entradaTeclado = "";
        Scanner entradaEscaner = new Scanner(System.in);
        entradaTeclado = entradaEscaner.nextLine();
        if(entradaTeclado.contains("añadir")){
            c.crearNeurona();
        }
        if(entradaTeclado.contains("mostrar")){
            c.mostrarNeuronas();
        }

        }
    }

    public static ArrayList<Neurona> getNeuronas() {
        return neuronas;
    }

    public static void setNeuronas(ArrayList<Neurona> neuronas) {
        Cerebro.neuronas = neuronas;
    }

    @Override
    public String toString() {
        String res = "";
        for(Neurona n : neuronas){
            res = res + n + " -- " + n.conectadas + "\n";

        }
        return res;
    }

    public void mostrarNeuronas(){
        System.out.println(neuronas.toString());
    }

    public void limpiarNeuronas(){

    }
}

