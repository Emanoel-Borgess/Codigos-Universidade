public class NotificacaoEmailDecorator extends NotificacaoDecorator {
    public NotificacaoEmailDecorator(Notificacao notificacao) {
        super(notificacao);
    }

    @Override
    public void enviar() {
        System.out.println("=== ENVIO DE EMAIL ===");
        System.out.println("Para: " + notificacao.getDestinatario());
        System.out.println("Mensagem: " + notificacao.getMensagem());
        System.out.println("=====================");
        notificacao.enviar();
    }

    @Override
    public String getMensagem() {
        return notificacao.getMensagem();
    }

    @Override
    public String getDestinatario() {
        return notificacao.getDestinatario();
    }
}