import java.util.List;

public class NotificacaoService implements MatchObserver {
    @Override
    public void update(Match match) {
        String mensagemDoador = "Seu item " + match.getItem().getNome() + 
                              " foi doado para " + match.getReceptor().getNome();
        String mensagemReceptor = "Você recebeu o item " + match.getItem().getNome() + 
                                " de " + match.getDoador().getNome();
        
        Notificacao notifDoador = new Notificacao(mensagemDoador, match.getDoador().getEmail());
        Notificacao notifReceptor = new Notificacao(mensagemReceptor, match.getReceptor().getEmail());
        
        NotificacaoDecorator notifDoadorDecorada = new NotificacaoEmailDecorator(notifDoador);
        NotificacaoDecorator notifReceptorDecorada = new NotificacaoSMSDecorator(notifReceptor);
        
        notifDoadorDecorada.enviar();
        notifReceptorDecorada.enviar();
    }

    public void notificarMatches(List<Match> matches) {
        for (Match match : matches) {
            update(match);
        }
    }
}