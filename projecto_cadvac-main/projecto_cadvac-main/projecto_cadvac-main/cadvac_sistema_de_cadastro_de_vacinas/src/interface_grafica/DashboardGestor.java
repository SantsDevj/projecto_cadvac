package interface_grafica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DashboardGestor extends JFrame {

    // Paleta de Cores (Baseada no Logo e nas Recomendações)
    private final Color AZUL_PRINCIPAL = new Color(0, 51, 102); // #003366 (Cabeçalho/Elementos Primários)
    private final Color AMARELO_DESTAQUE = new Color(255, 191, 0); // Amarelo do Logo (Para Ação Principal/Destaque)
    private final Color AZUL_CLARO_FUNDO = new Color(230, 240, 245); // #E6F0F5 (Fundo leve)
    private final Color CINZA_TEXTO = new Color(51, 51, 51); // #333333 (Textos e Ações Secundárias)

    public DashboardGestor(String nomeUsuario) {
        // 1. Configuração da Janela
        setTitle("CadVac - Painel de Gestão");
        setSize(700, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        getContentPane().setBackground(AZUL_CLARO_FUNDO);

        // 2. Painel Superior (Cabeçalho)
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(AZUL_PRINCIPAL);
        headerPanel.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));

        JLabel titleLabel = new JLabel("PAINEL DE GESTÃO, " + nomeUsuario.toUpperCase());
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        headerPanel.add(titleLabel, BorderLayout.WEST);

        // Botão de Sair/Logoff
        JButton logoffButton = new JButton("Sair");
        logoffButton.setBackground(AMARELO_DESTAQUE);
        logoffButton.setForeground(AZUL_PRINCIPAL);
        logoffButton.setFont(new Font("Arial", Font.BOLD, 12));
        logoffButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Saindo do sistema de Gestão.", "Logoff", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        });
        headerPanel.add(logoffButton, BorderLayout.EAST);
        
        add(headerPanel, BorderLayout.NORTH);

        // 3. Painel Central (Ações Principais)
        JPanel mainPanel = new JPanel(new GridLayout(2, 3, 30, 30)); // Layout 2x3 simples para botões
        mainPanel.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));
        mainPanel.setBackground(AZUL_CLARO_FUNDO);

        // Botões de funcionalidade específicos do Gestor:

        // 1. Gestão de Estoque (Requisito principal - Destaque Amarelo)
        addButton(mainPanel, "Gestão de Estoque", "Visualiza, atualiza e gerencia o estoque de vacinas.", AMARELO_DESTAQUE, AZUL_PRINCIPAL);

        // 2. Geração de Relatórios (Requisito principal - Azul Primário)
        addButton(mainPanel, "Geração de Relatórios", "Cria relatórios e análises de dados vacinais.", AZUL_PRINCIPAL, Color.WHITE);
        
        // 3. Gerenciar Usuários (Gestão do Sistema - Azul Primário)
        addButton(mainPanel, "Gerenciar Usuários", "Cadastra e gerencia profissionais e gestores.", AZUL_PRINCIPAL, Color.WHITE);
        
        // Ações Secundárias
        addButton(mainPanel, "Configurações", "Ajustes gerais do sistema e parâmetros.", CINZA_TEXTO, Color.WHITE);
        addButton(mainPanel, "Auditoria/Logs", "Acessa registros de atividade e segurança.", CINZA_TEXTO, Color.WHITE);
        addButton(mainPanel, "Ajuda e Suporte", "Manual e contato com a equipe técnica.", CINZA_TEXTO, Color.WHITE);

        add(mainPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    // Método auxiliar para criar botões com ação e estilo
    private void addButton(JPanel panel, String text, String tooltip, Color bgColor, Color fgColor) {
        JButton button = new JButton(text);
        button.setToolTipText(tooltip);
        button.setBackground(bgColor);
        button.setForeground(fgColor); 
        button.setFont(new Font("Arial", Font.BOLD, 14));
        
        // Ação simples: Simula o acesso à tela
        button.addActionListener(e -> JOptionPane.showMessageDialog(this, 
                                                                "Acessando a funcionalidade: " + text, 
                                                                "Navegação", 
                                                                JOptionPane.PLAIN_MESSAGE));

        panel.add(button);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Exemplo de execução para um gestor
            new DashboardGestor("Sr. Silva");
        });
    }
}