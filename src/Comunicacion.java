public class Comunicacion extends Thread{
    public int resultado;
    public int newResultado;
    boolean respuesta;
    public Comunicacion() {
        this.newResultado = 0;
        this.resultado = 0;
    }
    public Comunicacion(int resultado) {
        this.newResultado = resultado;
        this.resultado = resultado;
    }
    @Override
    public void run(){
        while (true){
            if(newResultado != resultado){
                System.out.println(newResultado);
                resultado = newResultado;
            }
        }
    }
    public void setResultado(int res){
        this.newResultado = res;
    }

    public boolean isRespuesta() {
        return respuesta;
    }

    public void setRespuesta(boolean respuesta) {
        this.respuesta = respuesta;
    }
}
