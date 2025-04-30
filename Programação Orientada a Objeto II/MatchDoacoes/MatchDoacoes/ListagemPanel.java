import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ListagemPanel extends JPanel {
    private SistemaDoacao sistema;
    private JTable dadosTable;
    private DefaultTableModel tableModel;

    public ListagemPanel(SistemaDoacao sistema) {
        this.sistema = sistema;
        initUI();
    }

    private void initUI() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Configuração da tabela
        String[] colunas = {"Tipo", "Nome", "Email", "Itens"};
        tableModel = new DefaultTableModel(colunas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        dadosTable = new JTable(tableModel);
        dadosTable.setAutoCreateRowSorter(true);
        dadosTable.getTableHeader().setReorderingAllowed(false);

        // Botão de atualização
        JButton atualizarButton = new JButton("Atualizar Listagem");
        atualizarButton.setBackground(new Color(70, 130, 180));
        atualizarButton.setForeground(Color.WHITE);
        atualizarButton.addActionListener(e -> atualizarListagem());

        // Layout
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(atualizarButton);
        
        add(buttonPanel, BorderLayout.NORTH);
        add(new JScrollPane(dadosTable), BorderLayout.CENTER);

        // Atualiza a listagem inicial
        atualizarListagem();
    }

    private void atualizarListagem() {
        tableModel.setRowCount(0); // Limpa a tabela

        // Adiciona doadores
        for (Doador doador : sistema.getDoadores()) {
            StringBuilder itens = new StringBuilder();
            for (Item item : doador.getItensParaDoar()) {
                itens.append(item.getNome()).append(" (").append(item.getCategoria()).append("), ");
            }
            tableModel.addRow(new Object[]{
                "Doador",
                doador.getNome(),
                doador.getEmail(),
                itens.length() > 0 ? itens.substring(0, itens.length()-2) : ""
            });
        }

        // Adiciona receptores
        for (Receptor receptor : sistema.getReceptores()) {
            StringBuilder itens = new StringBuilder();
            for (Item item : receptor.getItensNecessarios()) {
                itens.append(item.getNome()).append(" (").append(item.getCategoria()).append("), ");
            }
            tableModel.addRow(new Object[]{
                "Receptor",
                receptor.getNome(),
                receptor.getEmail(),
                itens.length() > 0 ? itens.substring(0, itens.length()-2) : ""
            });
        }
    }
}