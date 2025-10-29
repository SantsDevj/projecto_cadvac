package interface_grafica;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaLoginCadVac extends JFrame {

    // Paleta de Cores Integrada (Baseada no Logo e nas Recomendações)
    private final Color AZUL_PRINCIPAL = new Color(0, 51, 102); // #003366 (Azul Marinho - Principal) [cite: 32]
    private final Color AMARELO_DESTAQUE = new Color(255, 191, 0); // Amarelo/Dourado do Logo para botão principal
    private final Color CINZA_TEXTO = new Color(51, 51, 51); // #333333 (Cinza Escuro para textos) [cite: 39]
    private final Color AZUL_CLARO_FUNDO = new Color(230, 240, 245); // #E6F0F5 (Fundo leve) [cite: 34]

    public TelaLoginCadVac() {
        // Configuração da Janela (JFrame)
        setTitle("CadVac - Login de Usuário"); // Nome do Sistema: CadVac
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centralizar a janela
        setLayout(new BorderLayout()); // Layout principal
        getContentPane().setBackground(AZUL_CLARO_FUNDO); // Fundo da janela [cite: 34]

        // 1. Painel Superior (Cabeçalho/Título)
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(AZUL_PRINCIPAL); // Azul Escuro do Logo/Marinho [cite: 32]
        JLabel titleLabel = new JLabel("CADASTRO DE VACINAS - CadVac");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        headerPanel.add(titleLabel);
        add(headerPanel, BorderLayout.NORTH);

        // 2. Painel Central (Campos de Login)
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new GridBagLayout());
        loginPanel.setBackground(AZUL_CLARO_FUNDO);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;

        // Campo E-mail [cite: 4]
        JLabel emailLabel = new JLabel("E-mail:");
        emailLabel.setForeground(CINZA_TEXTO);
        JTextField emailField = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy = 0;
        loginPanel.add(emailLabel, gbc);
        gbc.gridx = 1;
        loginPanel.add(emailField, gbc);

        // Campo Senha [cite: 4]
        JLabel senhaLabel = new JLabel("Senha:");
        senhaLabel.setForeground(CINZA_TEXTO);
        JPasswordField senhaField = new JPasswordField(20);
        gbc.gridx = 0;
        gbc.gridy = 1;
        loginPanel.add(senhaLabel, gbc);
        gbc.gridx = 1;
        loginPanel.add(senhaField, gbc);

        // Botão Entrar [cite: 4]
        JButton entrarButton = new JButton("Entrar");
        entrarButton.setBackground(AMARELO_DESTAQUE); // Amarelo do Logo para botão principal
        entrarButton.setForeground(AZUL_PRINCIPAL); // Cor de texto contrastante
        entrarButton.setFont(new Font("Arial", Font.BOLD, 14));
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL; // Faz o botão preencher a largura
        loginPanel.add(entrarButton, gbc);

        // Ação do Botão (Simples)
        entrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica de autenticação simples: verifica se os campos não estão vazios
                String email = emailField.getText();
                String senha = new String(senhaField.getPassword());
                
                if (email.isEmpty() || senha.isEmpty()) {
                    // Vermelho para erros [cite: 40]
                    JOptionPane.showMessageDialog(TelaLoginCadVac.this, 
                                                  "Por favor, preencha o e-mail e a senha.", 
                                                  "Erro de Login", 
                                                  JOptionPane.ERROR_MESSAGE);
                } else {
                    // Simulação de sucesso (o sistema real faria a autenticação)
                    // Verde para sucesso [cite: 35]
                    JOptionPane.showMessageDialog(TelaLoginCadVac.this, 
                                                  "Login efetuado com sucesso!", 
                                                  "Sucesso", 
                                                  JOptionPane.INFORMATION_MESSAGE);
                    // O código real redirecionaria para o Dashboard do usuário [cite: 6]
                }
            }
        });

        // Link para Registro (Opcional) [cite: 5]
        JButton registroButton = new JButton("Não tem conta? Cadastre-se");
        registroButton.setBorderPainted(false); // Remove a borda
        registroButton.setContentAreaFilled(false); // Remove o fundo
        registroButton.setForeground(AZUL_PRINCIPAL); // Azul para link

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        loginPanel.add(registroButton, gbc);

        add(loginPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        // Garante que a GUI seja executada no thread de despacho de eventos
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TelaLoginCadVac();
            }
        });
    }
}
