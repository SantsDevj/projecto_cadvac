package telas_swing;
import javax.swing.*;
import java.awt.*;

public class CadastroUsuarioScreen extends JFrame {
    public CadastroUsuarioScreen(){
        setTitle("Cadastro de Usuário");
        setSize(520,420);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        initUI();
    }
    private void initUI(){
        JPanel p = new JPanel(new GridBagLayout());
        p.setBackground(Colors.AZUL_CLARO);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8,8,8,8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx=0; gbc.gridy=0; p.add(new JLabel("Nome:"), gbc);
        gbc.gridx=1; JTextField nome = new JTextField(20); p.add(nome, gbc);

        gbc.gridx=0; gbc.gridy++; p.add(new JLabel("E-mail:"), gbc);
        gbc.gridx=1; JTextField email = new JTextField(20); p.add(email, gbc);

        gbc.gridx=0; gbc.gridy++; p.add(new JLabel("Senha:"), gbc);
        gbc.gridx=1; JPasswordField senha = new JPasswordField(20); p.add(senha, gbc);

        gbc.gridx=0; gbc.gridy++; p.add(new JLabel("Tipo de Usuário:"), gbc);
        gbc.gridx=1; JComboBox<String> tipo = new JComboBox<>(new String[]{"Paciente","Profissional","Gestor"}); p.add(tipo, gbc);

        gbc.gridx=0; gbc.gridy++; gbc.gridwidth=2; JButton salvar = new JButton("Cadastrar");
        salvar.addActionListener(e -> JOptionPane.showMessageDialog(this, "Cadastro realizado (demo).", "OK", JOptionPane.INFORMATION_MESSAGE));
        p.add(salvar, gbc);

        add(p);
    }
}
