import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroPanel extends JPanel {
    private SistemaDoacao sistema;
    private JComboBox<String> tipoCadastro;
    private JTextField nomeField, emailField, itemField, categoriaField, descricaoField;
    private JButton cadastrarButton;

    public CadastroPanel(SistemaDoacao sistema) {
        this.sistema = sistema;
        initUI();
    }

    private void initUI() {
        setLayout(new GridLayout(7, 2));

        add(new JLabel("Tipo:"));
        tipoCadastro = new JComboBox<>(new String[]{"Doador", "Receptor"});
        add(tipoCadastro);

        add(new JLabel("Nome:"));
        nomeField = new JTextField();
        add(nomeField);

        add(new JLabel("Email:"));
        emailField = new JTextField();
        add(emailField);

        add(new JLabel("Item:"));
        itemField = new JTextField();
        add(itemField);

        add(new JLabel("Categoria:"));
        categoriaField = new JTextField();
        add(categoriaField);

        add(new JLabel("Descrição:"));
        descricaoField = new JTextField();
        add(descricaoField);

        cadastrarButton = new JButton("Cadastrar");
        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrar();
            }
        });
        add(cadastrarButton);
    }

    private void cadastrar() {
        String nome = nomeField.getText();
        String email = emailField.getText();
        String itemNome = itemField.getText();
        String categoria = categoriaField.getText();
        String descricao = descricaoField.getText();

        Item item = new Item(itemNome, categoria, descricao);

        if (tipoCadastro.getSelectedItem().equals("Doador")) {
            Doador doador = new Doador(nome, email);
            doador.adicionarItem(item);
            sistema.cadastrarDoador(doador);
            JOptionPane.showMessageDialog(this, "Doador cadastrado com sucesso!");
        } else {
            Receptor receptor = new Receptor(nome, email);
            receptor.adicionarItemNecessario(item);
            sistema.cadastrarReceptor(receptor);
            JOptionPane.showMessageDialog(this, "Receptor cadastrado com sucesso!");
        }

        limparCampos();
    }

    private void limparCampos() {
        nomeField.setText("");
        emailField.setText("");
        itemField.setText("");
        categoriaField.setText("");
        descricaoField.setText("");
    }
}