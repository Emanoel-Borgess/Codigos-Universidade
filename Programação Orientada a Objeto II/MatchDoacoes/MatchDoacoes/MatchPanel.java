import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;


public class MatchPanel extends JPanel {
    private SistemaDoacao sistema;
    private JComboBox<String> tipoUsuario;
    private JComboBox<String> estrategiaMatch;
    private JButton realizarMatchButton;
    private JTable listaUsuariosTable;
    private DefaultTableModel tableModel;
    private JLabel statusLabel;

    public MatchPanel(SistemaDoacao sistema) {
        this.sistema = sistema;
        initUI();
    }

    private void initUI() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Painel superior com controles
        JPanel topPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        
        topPanel.add(new JLabel("Tipo de Usuário:"));
        tipoUsuario = new JComboBox<>(new String[]{"Doador", "Receptor"});
        tipoUsuario.addActionListener(e -> atualizarListaUsuarios());
        topPanel.add(tipoUsuario);

        topPanel.add(new JLabel("Estratégia de Match:"));
        estrategiaMatch = new JComboBox<>(new String[]{"Item Exato", "Por Categoria"});
        topPanel.add(estrategiaMatch);

        statusLabel = new JLabel("Selecione um usuário e clique em Realizar Match");
        topPanel.add(statusLabel);

        // Configuração da tabela
        String[] colunas = {"Nome", "Email", "Itens"};
        tableModel = new DefaultTableModel(colunas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        listaUsuariosTable = new JTable(tableModel);
        listaUsuariosTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaUsuariosTable.getTableHeader().setReorderingAllowed(false);
        listaUsuariosTable.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                atualizarStatus();
            }
        });

        // Botão para realizar match
        realizarMatchButton = new JButton("Realizar Match");
        realizarMatchButton.setBackground(new Color(0, 100, 0));
        realizarMatchButton.setForeground(Color.WHITE);
        realizarMatchButton.addActionListener(e -> realizarMatch());

        // Layout
        add(topPanel, BorderLayout.NORTH);
        add(new JScrollPane(listaUsuariosTable), BorderLayout.CENTER);
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(realizarMatchButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // Atualiza a lista inicial
        atualizarListaUsuarios();
    }

    private void atualizarListaUsuarios() {
        tableModel.setRowCount(0); // Limpa a tabela
        
        boolean isDoador = tipoUsuario.getSelectedItem().equals("Doador");
        
        if (isDoador) {
            // Mostra receptores para doadores
            for (Receptor receptor : sistema.getReceptores()) {
                StringBuilder itens = new StringBuilder();
                for (Item item : receptor.getItensNecessarios()) {
                    itens.append(item.getNome()).append(" (").append(item.getCategoria()).append("), ");
                }
                tableModel.addRow(new Object[]{
                    receptor.getNome(),
                    receptor.getEmail(),
                    itens.length() > 0 ? itens.substring(0, itens.length()-2) : ""
                });
            }
        } else {
            // Mostra doadores para receptores
            for (Doador doador : sistema.getDoadores()) {
                StringBuilder itens = new StringBuilder();
                for (Item item : doador.getItensParaDoar()) {
                    itens.append(item.getNome()).append(" (").append(item.getCategoria()).append("), ");
                }
                tableModel.addRow(new Object[]{
                    doador.getNome(),
                    doador.getEmail(),
                    itens.length() > 0 ? itens.substring(0, itens.length()-2) : ""
                });
            }
        }
        atualizarStatus();
    }

    private void atualizarStatus() {
        int selectedRow = listaUsuariosTable.getSelectedRow();
        if (selectedRow == -1) {
            statusLabel.setText("Selecione um usuário e clique em Realizar Match");
            realizarMatchButton.setEnabled(false);
        } else {
            boolean isDoador = tipoUsuario.getSelectedItem().equals("Doador");
            String tipoSelecionado = isDoador ? "Receptor" : "Doador";
            String nome = (String) tableModel.getValueAt(selectedRow, 0);
            statusLabel.setText(tipoSelecionado + " selecionado: " + nome);
            realizarMatchButton.setEnabled(true);
        }
    }

    private void realizarMatch() {
        int selectedRow = listaUsuariosTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, 
                "Selecione um usuário na tabela!", 
                "Aviso", 
                JOptionPane.WARNING_MESSAGE);
            return;
        }

        String estrategia = (String) estrategiaMatch.getSelectedItem();
        boolean isDoador = tipoUsuario.getSelectedItem().equals("Doador");
        
        try {
            // Configura a estratégia de match
            MatchStrategy strategy = estrategia.equals("Item Exato") 
                ? new MatchPorItemExato() 
                : new MatchPorCategoria();
            
            sistema.setMatchStrategy(strategy);
            
            if (isDoador) {
                // Doador selecionando receptor
                Doador doador = getDoadorAtual();
                Receptor receptor = sistema.getReceptores().get(selectedRow);
                
                // Cria lista temporária com apenas o receptor selecionado
                List<Receptor> receptoresSelecionados = new ArrayList<>();
                receptoresSelecionados.add(receptor);
                
                // Realiza match apenas com o receptor selecionado
                List<Match> matches = strategy.realizarMatch(
                    List.of(doador), 
                    receptoresSelecionados
                );
                
                if (!matches.isEmpty()) {
                    sistema.getMatches().addAll(matches);
                    sistema.getNotificacaoService().notificarMatches(matches);
                    JOptionPane.showMessageDialog(this, 
                        "Match realizado com sucesso!\n" +
                        "Doador: " + doador.getNome() + "\n" +
                        "Receptor: " + receptor.getNome() + "\n" +
                        "Item: " + matches.get(0).getItem().getNome(), 
                        "Sucesso", 
                        JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, 
                        "Nenhum match encontrado com os critérios selecionados", 
                        "Aviso", 
                        JOptionPane.WARNING_MESSAGE);
                }
            } else {
                // Receptor selecionando doador
                Receptor receptor = getReceptorAtual();
                Doador doador = sistema.getDoadores().get(selectedRow);
                
                // Cria lista temporária com apenas o doador selecionado
                List<Doador> doadoresSelecionados = new ArrayList<>();
                doadoresSelecionados.add(doador);
                
                // Realiza match apenas com o doador selecionado
                List<Match> matches = strategy.realizarMatch(
                    doadoresSelecionados, 
                    List.of(receptor)
                );
                
                if (!matches.isEmpty()) {
                    sistema.getMatches().addAll(matches);
                    sistema.getNotificacaoService().notificarMatches(matches);
                    JOptionPane.showMessageDialog(this, 
                        "Match realizado com sucesso!\n" +
                        "Receptor: " + receptor.getNome() + "\n" +
                        "Doador: " + doador.getNome() + "\n" +
                        "Item: " + matches.get(0).getItem().getNome(), 
                        "Sucesso", 
                        JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, 
                        "Nenhum match encontrado com os critérios selecionados", 
                        "Aviso", 
                        JOptionPane.WARNING_MESSAGE);
                }
            }
            
            atualizarListaUsuarios();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, 
                "Erro ao realizar match: " + e.getMessage(), 
                "Erro", 
                JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    private Doador getDoadorAtual() {
        // Implementação para obter o doador logado
        // Neste exemplo, pegamos o primeiro doador como exemplo
        if (!sistema.getDoadores().isEmpty()) {
            return sistema.getDoadores().get(0);
        }
        throw new IllegalStateException("Nenhum doador cadastrado");
    }

    private Receptor getReceptorAtual() {
        // Implementação para obter o receptor logado
        // Neste exemplo, pegamos o primeiro receptor como exemplo
        if (!sistema.getReceptores().isEmpty()) {
            return sistema.getReceptores().get(0);
        }
        throw new IllegalStateException("Nenhum receptor cadastrado");
    }
}