public class Match {
    private Doador doador;
    private Receptor receptor;
    private Item item;

    public Match(Doador doador, Receptor receptor, Item item) {
        this.doador = doador;
        this.receptor = receptor;
        this.item = item;
    }

    // Getters
    public Doador getDoador() { return doador; }
    public Receptor getReceptor() { return receptor; }
    public Item getItem() { return item; }
}