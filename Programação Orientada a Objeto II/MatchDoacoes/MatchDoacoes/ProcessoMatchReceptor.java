import java.util.List;


public class ProcessoMatchReceptor extends ProcessoMatchTemplate {
    private Receptor receptor;
    private List<Doador> doadores;
    private List<Match> matches;

    public ProcessoMatchReceptor(Receptor receptor, List<Doador> doadores) {
        this.receptor = receptor;
        this.doadores = doadores;
    }

    @Override
    protected void prepararDados() {
        System.out.println("Preparando dados para match do receptor: " + receptor.getNome());
    }

    @Override
    protected List<Match> realizarMatch() {
        MatchStrategy strategy = new MatchPorItemExato();
        matches = strategy.realizarMatch(doadores, List.of(receptor));
        return matches;
    }

    @Override
    protected void notificarPartes(List<Match> matches) {
        NotificacaoService service = new NotificacaoService();
        service.notificarMatches(matches);
    }
}