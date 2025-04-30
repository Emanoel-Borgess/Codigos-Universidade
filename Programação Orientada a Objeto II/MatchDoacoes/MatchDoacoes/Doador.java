import java.util.ArrayList;
import java.util.List;

public class Doador {
    private String nome;
    private String email;
    private List<Item> itensParaDoar;

    public Doador(String nome, String email) {
        this.nome = nome;
        this.email = email;
        this.itensParaDoar = new ArrayList<>();
    }

    public void adicionarItem(Item item) {
        itensParaDoar.add(item);
    }

    // Getters
    public String getNome() { return nome; }
    public String getEmail() { return email; }
    public List<Item> getItensParaDoar() { return itensParaDoar; }
}