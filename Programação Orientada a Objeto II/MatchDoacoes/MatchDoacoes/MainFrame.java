import javax.swing.*;



public class MainFrame extends JFrame {
    private SistemaDoacao sistema;
    private JTabbedPane tabbedPane;

    public MainFrame(SistemaDoacao sistema) {
        this.sistema = sistema;
        initUI();
    }

    private void initUI() {
        setTitle("Sistema de Match de Doações");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Cadastro", new CadastroPanel(sistema));
        tabbedPane.addTab("Match", new MatchPanel(sistema));
        tabbedPane.addTab("Listagem", new ListagemPanel(sistema));

        add(tabbedPane);
    }
}