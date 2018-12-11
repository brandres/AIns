public class Entrada {
    public int calculo;
    public int entrada;
    public long id;
    public Entrada(int c, int e, long i){
        calculo = c;
        entrada = e;
        id = i;
    }

    public int getCalculo() {
        return calculo;
    }

    public void setCalculo(int calculo) {
        this.calculo = calculo;
    }

    public int getEntrada() {
        return entrada;
    }

    public void setEntrada(int entrada) {
        this.entrada = entrada;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
