package telas_swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class LoginScreen extends JFrame {
    private JTextField emailField;
    private JPasswordField passwordField;

    public LoginScreen() {
        setTitle("Login - Sistema de Vacinação");
        setSize(420, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initUI();
    }

    private void initUI() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Colors.AZUL_CLARO);

        // Header
        JLabel header = new JLabel("Entrar", SwingConstants.CENTER);
        header.setOpaque(true);
        header.setBackground(Colors.AZUL_ESCURO);
        header.setForeground(Color.WHITE);
        header.setFont(header.getFont().deriveFont(Font.BOLD, 20f));
        header.setBorder(BorderFactory.createEmptyBorder(12,12,12,12));
        panel.add(header, BorderLayout.NORTH);

        // Form
        JPanel form = new JPanel();
        form.setOpaque(false);
        form.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8,8,8,8);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0; gbc.gridy = 0;
        form.add(new JLabel("E-mail:"), gbc);
        gbc.gridx = 1;
        emailField = new JTextField(18);
        form.add(emailField, gbc);

        gbc.gridx = 0; gbc.gridy++;
        form.add(new JLabel("Senha:"), gbc);
        gbc.gridx = 1;
        passwordField = new JPasswordField(18);
        form.add(passwordField, gbc);

        gbc.gridx = 0; gbc.gridy++;
        gbc.gridwidth = 2;
        JButton loginBtn = new JButton("Entrar");
        loginBtn.setBackground(Colors.AZUL_ESCURO);
        loginBtn.setForeground(Color.WHITE);
        loginBtn.addActionListener((ActionEvent e) -> onLogin());
        form.add(loginBtn, gbc);

        gbc.gridy++;
        JPanel links = new JPanel(new FlowLayout(FlowLayout.CENTER));
        links.setOpaque(false);
        JButton register = new JButton("Registrar-se");
        register.addActionListener(ev -> {
            new CadastroUsuarioScreen().setVisible(true);
            this.dispose();
        });
        links.add(register);
        form.add(links, gbc);

        panel.add(form, BorderLayout.CENTER);
        add(panel);
    }

    private void onLogin() {
        // Placeholder: in a real app validate credentials and redirect based on role
        // For demo, open DashboardPaciente
        JOptionPane.showMessageDialog(this, "Login bem-sucedido (demo). Abrindo Dashboard do Paciente.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        new DashboardPaciente().setVisible(true);
        this.dispose();
    }
}
