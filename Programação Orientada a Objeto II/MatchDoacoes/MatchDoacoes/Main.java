public class Main {
    public static void main(String[] args) {
        SistemaDoacao sistema = new SistemaDoacao();
        MainFrame mainFrame = new MainFrame(sistema);
        mainFrame.setVisible(true);
    }
}