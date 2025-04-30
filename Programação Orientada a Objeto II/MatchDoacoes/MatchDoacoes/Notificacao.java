public class Notificacao {
    private String mensagem;
    private String destinatario;

    public Notificacao(String mensagem, String destinatario) {
        this.mensagem = mensagem;
        this.destinatario = destinatario;
    }

    public void enviar() {
        System.out.println("Enviando notificação para " + destinatario + ": " + mensagem);
    }

    public String getMensagem() { return mensagem; }
    public String getDestinatario() { return destinatario; }
}