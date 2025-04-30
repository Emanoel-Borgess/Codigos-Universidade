

public class ReceptorAdapter {
    private Receptor receptor;

    public ReceptorAdapter(Receptor receptor) {
        this.receptor = receptor;
    }

    public String getInfo() {
        return "Receptor: " + receptor.getNome() + " - Itens necessários: " + 
               receptor.getItensNecessarios().size();
    }

    public Receptor getReceptor() {
        return receptor;
    }
}