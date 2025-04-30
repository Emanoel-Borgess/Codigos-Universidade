public abstract class NotificacaoDecorator {
    protected Notificacao notificacao;

    public NotificacaoDecorator(Notificacao notificacao) {
        this.notificacao = notificacao;
    }

    public abstract void enviar();
    public abstract String getMensagem();
    public abstract String getDestinatario();
}