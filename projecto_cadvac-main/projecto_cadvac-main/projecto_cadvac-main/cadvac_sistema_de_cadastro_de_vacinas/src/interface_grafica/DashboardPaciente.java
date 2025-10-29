package interface_grafica;

import javax.swing.*;
import java.awt.*;

public class DashboardPaciente extends JFrame {

    // Paleta de Cores (Baseada no Logo e nas Recomendações)
    private final Color AZUL_PRINCIPAL = new Color(0, 51, 102); // #003366 (Cabeçalho/Primários)
    private final Color AMARELO_DESTAQUE = new Color(255, 191, 0); // Amarelo do Logo (Para Destaque/Logoff)
    private final Color VERDE_SUCESSO = new Color(76, 175, 80); // #4CAF50 (Para Alertas/Positivo)
    private final Color AZUL_CLARO_FUNDO = new Color(230, 240, 245); // #E6F0F5 (Fundo leve)
    private final Color CINZA_TEXTO = new Color(51, 51, 51); // #333333 (Textos)

    public DashboardPaciente(String nomeUsuario) {
        // 1. Configuração da Janela
        setTitle("CadVac - Painel do Paciente");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        getContentPane().setBackground(AZUL_CLARO_FUNDO);

        // 2. Painel Superior (Cabeçalho)
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(AZUL_PRINCIPAL);
        headerPanel.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));

        JLabel titleLabel = new JLabel("MEU CADVAC, " + nomeUsuario.toUpperCase() + "!");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        headerPanel.add(titleLabel, BorderLayout.WEST);

        // Botão de Sair
        JButton logoffButton = new JButton("Sair");
        logoffButton.setBackground(AMARELO_DESTAQUE);
        logoffButton.setForeground(AZUL_PRINCIPAL);
        logoffButton.setFont(new Font("Arial", Font.BOLD, 12));
        logoffButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Saindo do Cadastro de Vacinas.", "Logoff", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        });
        headerPanel.add(logoffButton, BorderLayout.EAST);
        
        add(headerPanel, BorderLayout.NORTH);

        // 3. Painel Central (Ações Principais)
        JPanel mainPanel = new JPanel(new GridLayout(2, 2, 25, 25)); // Layout simples 2x2
        mainPanel.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));
        mainPanel.setBackground(AZUL_CLARO_FUNDO);

        // Botões de funcionalidade específicos do Paciente

        // 1. Consultar Histórico (Requisito principal)
        addButton(mainPanel, "Consultar Histórico", "Visualiza o registro completo de vacinas aplicadas.", AZUL_PRINCIPAL); 

        // 2. Alertas Pendentes (Requisito principal)
        addButton(mainPanel, "Alertas Pendentes", "Notificações de vacinas que precisam ser tomadas.", VERDE_SUCESSO);

        // 3. Vacinas no Sistema (Informação útil)
        addButton(mainPanel, "Vacinas Disponíveis", "Consulta informações sobre vacinas registradas.", CINZA_TEXTO);

        // 4. Meu Perfil (Gestão de Dados)
        addButton(mainPanel, "Meu Perfil", "Atualizar informações e dados cadastrais.", CINZA_TEXTO);

        add(mainPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    // Método auxiliar para criar e adicionar botões com estilo
    private void addButton(JPanel panel, String text, String tooltip, Color bgColor) {
        JButton button = new JButton(text);
        button.setToolTipText(tooltip);
        button.setBackground(bgColor);
        button.setForeground(Color.WHITE); 
        button.setFont(new Font("Arial", Font.BOLD, 16));
        
        // Ação simples: Simula o acesso à tela
        button.addActionListener(e -> JOptionPane.showMessageDialog(this, 
                                                                "Abrindo a Tela de: " + text, 
                                                                "Navegação", 
                                                                JOptionPane.PLAIN_MESSAGE));

        panel.add(button);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Exemplo de execução para um paciente
            new DashboardPaciente("Ana Silva");
        });
    }
}
