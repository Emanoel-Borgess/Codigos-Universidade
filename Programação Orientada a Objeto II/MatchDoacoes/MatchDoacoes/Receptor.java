import java.util.ArrayList;
import java.util.List;

public class Receptor {
    private String nome;
    private String email;
    private List<Item> itensNecessarios;

    public Receptor(String nome, String email) {
        this.nome = nome;
        this.email = email;
        this.itensNecessarios = new ArrayList<>();
    }

    public void adicionarItemNecessario(Item item) {
        itensNecessarios.add(item);
    }

    // Getters
    public String getNome() { return nome; }
    public String getEmail() { return email; }
    public List<Item> getItensNecessarios() { return itensNecessarios; }
}