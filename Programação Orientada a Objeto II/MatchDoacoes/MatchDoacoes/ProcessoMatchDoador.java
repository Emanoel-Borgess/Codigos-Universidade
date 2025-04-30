import java.util.List;


public class ProcessoMatchDoador extends ProcessoMatchTemplate {
    private Doador doador;
    private List<Receptor> receptores;
    private List<Match> matches;

    public ProcessoMatchDoador(Doador doador, List<Receptor> receptores) {
        this.doador = doador;
        this.receptores = receptores;
    }

    @Override
    protected void prepararDados() {
        System.out.println("Preparando dados para match do doador: " + doador.getNome());
    }

    @Override
    protected List<Match> realizarMatch() {
        MatchStrategy strategy = new MatchPorItemExato();
        matches = strategy.realizarMatch(List.of(doador), receptores);
        return matches;
    }

    @Override
    protected void notificarPartes(List<Match> matches) {
        NotificacaoService service = new NotificacaoService();
        service.notificarMatches(matches);
    }
}