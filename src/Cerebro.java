import java.io.*;
import java.util.ArrayList;

public class Cerebro{
    public static ArrayList<Neurona> neuronas;

    public Cerebro() {
        try{
            load();
        }catch (Exception e){
            neuronas = new ArrayList<Neurona>();
        }

        try{
            for(Neurona n : neuronas){
                n.start();
            }
        }catch (NullPointerException err){

        }

    }
    public void save(){
        try {
            FileOutputStream fos = new FileOutputStream("recuerdos.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(neuronas); // write MenuArray to ObjectOutputStream
            oos.close();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    public void load() throws Exception{
            FileInputStream fos = new FileInputStream("recuerdos.txt");
            ObjectInputStream input = new ObjectInputStream(fos);
            neuronas = (ArrayList<Neurona>) input.readObject();
            input.close();
    }
    public void añadirNeurona(Neurona n){
        neuronas.add(n);
        n.start();
        save();
    }
    public void crearNeurona(){
        neuronas.add(new Neurona());
        neuronas.get(neuronas.size() - 1).start();
        save();
    }
    public static void main(String[] args){
        Cerebro c = new Cerebro();
        System.out.println(neuronas);
    }

}
