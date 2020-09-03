package patterns.factory;

public class Telefono extends Prodotto {

    private String marca;

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void telefona() {
        System.out.println("Sto chiamando");
    }

}
