

public class DoadorAdapter {
    private Doador doador;

    public DoadorAdapter(Doador doador) {
        this.doador = doador;
    }

    public String getInfo() {
        return "Doador: " + doador.getNome() + " - Itens para doar: " + 
               doador.getItensParaDoar().size();
    }

    public Doador getDoador() {
        return doador;
    }
}