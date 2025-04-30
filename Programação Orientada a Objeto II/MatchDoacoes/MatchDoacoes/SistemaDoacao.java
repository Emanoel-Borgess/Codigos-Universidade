import java.util.ArrayList;
import java.util.List;

public class SistemaDoacao {
    private List<Doador> doadores;
    private List<Receptor> receptores;
    private List<Match> matches;
    private NotificacaoService notificacaoService;
    private MatchStrategy strategy;

    public SistemaDoacao() {
        this.doadores = new ArrayList<>();
        this.receptores = new ArrayList<>();
        this.matches = new ArrayList<>();
        this.notificacaoService = new NotificacaoService();
        this.strategy = new MatchPorItemExato();
    }

    // Métodos para cadastro
    public void cadastrarDoador(Doador doador) {
        doadores.add(doador);
    }

    public void cadastrarReceptor(Receptor receptor) {
        receptores.add(receptor);
    }

    // Métodos de acesso
    public List<Doador> getDoadores() {
        return doadores;
    }

    public List<Receptor> getReceptores() {
        return receptores;
    }

    public List<Match> getMatches() {
        return matches;
    }

    public NotificacaoService getNotificacaoService() {
        return notificacaoService;
    }

    // Métodos para match
    public void setMatchStrategy(MatchStrategy strategy) {
        this.strategy = strategy;
    }

    public List<Match> realizarMatches() {
        List<Match> novosMatches = strategy.realizarMatch(doadores, receptores);
        matches.addAll(novosMatches);
        notificacaoService.notificarMatches(novosMatches);
        return novosMatches;
    }

    // Métodos de busca
    public Doador encontrarDoador(String nome) {
        return doadores.stream()
            .filter(d -> d.getNome().equalsIgnoreCase(nome))
            .findFirst()
            .orElse(null);
    }

    public Receptor encontrarReceptor(String nome) {
        return receptores.stream()
            .filter(r -> r.getNome().equalsIgnoreCase(nome))
            .findFirst()
            .orElse(null);
    }
}