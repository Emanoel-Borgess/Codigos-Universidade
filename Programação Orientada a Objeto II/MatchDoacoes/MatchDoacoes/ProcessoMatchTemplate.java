import java.util.List;


public abstract class ProcessoMatchTemplate {
    public final void processar() {
        prepararDados();
        List<Match> matches = realizarMatch();
        notificarPartes(matches);
        finalizarProcesso();
    }

    protected abstract void prepararDados();
    protected abstract List<Match> realizarMatch();
    protected abstract void notificarPartes(List<Match> matches);
    
    protected void finalizarProcesso() {
        System.out.println("Processo de match finalizado");
    }
}