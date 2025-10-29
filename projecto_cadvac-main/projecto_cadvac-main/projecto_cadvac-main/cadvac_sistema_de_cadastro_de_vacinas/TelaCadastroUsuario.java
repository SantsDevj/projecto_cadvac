import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaCadastroUsuario extends JFrame {

    // Paleta de Cores (Baseada no documento de Interface)
    private final Color AZUL_PRINCIPAL = new Color(0, 51, 102);     // #003366 (Cabeçalho/Primário)
    private final Color AZUL_CLARO_FUNDO = new Color(230, 240, 245); // #E6F0F5 (Fundo leve)
    private final Color VERDE_SUCESSO = new Color(76, 175, 80);     // #4CAF50 (Botão de Cadastro)
    private final Color CINZA_TEXTO = new Color(51, 51, 51);        // #333333 (Textos)

    private JTextField nomeField;
    private JTextField emailField;
    private JPasswordField senhaField;
    private JComboBox<String> tipoUsuarioCombo;
    private JTextField documentoField; // Campo que muda (e.g., Cartão de Saúde, CRM)

    public TelaCadastroUsuario() {
        // 1. Configuração da Janela
        setTitle("CadVac - Cadastro de Novo Usuário (RF01)");
        setSize(550, 480);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        getContentPane().setBackground(AZUL_CLARO_FUNDO);

        // 2. Painel Superior (Cabeçalho/Título)
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(AZUL_PRINCIPAL);
        JLabel titleLabel = new JLabel("CADASTRO DE NOVO USUÁRIO (RF01)");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        headerPanel.add(titleLabel);
        add(headerPanel, BorderLayout.NORTH);

        // 3. Painel Central (Formulário)
        JPanel formPanel = new JPanel(new GridLayout(6, 2, 15, 15)); // Layout simples 6x2
        formPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        formPanel.setBackground(AZUL_CLARO_FUNDO);

        // Componentes do Formulário

        // Nome Completo
        JLabel nomeLabel = new JLabel("Nome Completo:");
        nomeLabel.setForeground(CINZA_TEXTO);
        nomeField = new JTextField(20);

        // E-mail
        JLabel emailLabel = new JLabel("E-mail:");
        emailLabel.setForeground(CINZA_TEXTO);
        emailField = new JTextField(20);

        // Senha
        JLabel senhaLabel = new JLabel("Senha:");
        senhaLabel.setForeground(CINZA_TEXTO);
        senhaField = new JPasswordField(20);

        // Tipo de Usuário (Define a permissão e campos adicionais)
        JLabel tipoUsuarioLabel = new JLabel("Tipo de Usuário:");
        tipoUsuarioLabel.setForeground(CINZA_TEXTO);
        String[] tipos = {"Paciente", "Profissional de Saúde", "Gestor"};
        tipoUsuarioCombo = new JComboBox<>(tipos);

        // Campo Variável (Cartão de Saúde, CRM, etc.)
        JLabel documentoLabel = new JLabel("Cartão de Saúde/Doc. de Identificação:");
        documentoLabel.setForeground(CINZA_TEXTO);
        documentoField = new JTextField(20);

        // Ação para mudar o rótulo do campo com base no tipo de usuário
        tipoUsuarioCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tipoSelecionado = (String) tipoUsuarioCombo.getSelectedItem();
                switch (tipoSelecionado) {
                    case "Profissional de Saúde":
                        documentoLabel.setText("CRM/Número de Identificação:");
                        break;
                    case "Gestor":
                        documentoLabel.setText("ID Administrativo:");
                        break;
                    case "Paciente":
                    default:
                        documentoLabel.setText("Cartão de Saúde/Doc. de Identificação:");
                        break;
                }
            }
        });
        
        // Espaço para estética
        JLabel espaco = new JLabel(""); 
        
        // Adiciona componentes ao formulário
        formPanel.add(nomeLabel);
        formPanel.add(nomeField);
        formPanel.add(emailLabel);
        formPanel.add(emailField);
        formPanel.add(senhaLabel);
        formPanel.add(senhaField);
        formPanel.add(tipoUsuarioLabel);
        formPanel.add(tipoUsuarioCombo);
        formPanel.add(documentoLabel);
        formPanel.add(documentoField);
        formPanel.add(espaco); // Espaço
        
        add(formPanel, BorderLayout.CENTER);

        // 4. Painel Inferior (Botões de Ação)
        JPanel footerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        footerPanel.setBackground(AZUL_CLARO_FUNDO);

        JButton cadastrarButton = new JButton("Cadastrar Usuário");
        cadastrarButton.setBackground(VERDE_SUCESSO);
        cadastrarButton.setForeground(Color.WHITE);
        cadastrarButton.setFont(new Font("Arial", Font.BOLD, 14));
        cadastrarButton.setPreferredSize(new Dimension(200, 35));

        // Ação simples para Cadastrar
        cadastrarButton.addActionListener(e -> {
            String nome = nomeField.getText();
            String email = emailField.getText();
            String tipo = (String) tipoUsuarioCombo.getSelectedItem();
            
            if (nome.isEmpty() || email.isEmpty() || new String(senhaField.getPassword()).isEmpty()) {
                 JOptionPane.showMessageDialog(this, 
                    "Por favor, preencha todos os campos obrigatórios.", 
                    "Erro de Validação", 
                    JOptionPane.ERROR_MESSAGE);
                return;
            }

            JOptionPane.showMessageDialog(this, 
                "Usuário '" + nome + "' (" + tipo + ") registrado com sucesso!", 
                "Registro Concluído (RF01)", 
                JOptionPane.INFORMATION_MESSAGE);
            // O código real faria o hash da senha e salvaria no banco de dados.
        });

        footerPanel.add(cadastrarButton);

        add(footerPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TelaCadastroUsuario();
        });
    }
}