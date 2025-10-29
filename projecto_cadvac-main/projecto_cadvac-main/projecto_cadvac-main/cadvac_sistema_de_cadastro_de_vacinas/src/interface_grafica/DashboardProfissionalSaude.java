package interface_grafica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DashboardProfissionalSaude extends JFrame {

    // Paleta de Cores (Baseada no Logo e nas Recomendações)
    private final Color AZUL_PRINCIPAL = new Color(0, 51, 102); // #003366 (Cabeçalho/Elementos Primários) [cite: 31, 32]
    private final Color AMARELO_DESTAQUE = new Color(255, 191, 0); // Amarelo do Logo (Ação Principal)
    private final Color AZUL_CLARO_FUNDO = new Color(230, 240, 245); // #E6F0F5 (Fundo leve) [cite: 34]
    private final Color CINZA_TEXTO = new Color(51, 51, 51); // #333333 (Textos) [cite: 39]

    public DashboardProfissionalSaude(String nomeUsuario) {
        // 1. Configuração da Janela
        setTitle("CadVac - Painel do Profissional de Saúde");
        setSize(750, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        getContentPane().setBackground(AZUL_CLARO_FUNDO);

        // 2. Painel Superior (Cabeçalho)
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(AZUL_PRINCIPAL);
        headerPanel.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));

        JLabel titleLabel = new JLabel("BEM-VINDO(A), DR(A). " + nomeUsuario.toUpperCase());
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        headerPanel.add(titleLabel, BorderLayout.WEST);

        // Botão de Sair
        JButton logoffButton = new JButton("Sair");
        logoffButton.setBackground(AMARELO_DESTAQUE);
        logoffButton.setForeground(AZUL_PRINCIPAL);
        logoffButton.setFont(new Font("Arial", Font.BOLD, 12));
        logoffButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Saindo da sessão.", "Logoff", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        });
        headerPanel.add(logoffButton, BorderLayout.EAST);
        
        add(headerPanel, BorderLayout.NORTH);

        // 3. Painel Central (Ações Principais)
        JPanel mainPanel = new JPanel(new GridLayout(2, 3, 30, 30)); // 2 linhas, 3 colunas, com espaçamento
        mainPanel.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));
        mainPanel.setBackground(AZUL_CLARO_FUNDO);

        // Adiciona os botões de funcionalidade
        addButton(mainPanel, "Registrar Aplicação", "Lançar vacina aplicada no paciente (RF03)", AMARELO_DESTAQUE, AZUL_PRINCIPAL);
        addButton(mainPanel, "Consultar Paciente", "Buscar histórico vacinal de um paciente (RF04)", AZUL_PRINCIPAL, Color.WHITE);
        addButton(mainPanel, "Gestão de Vacinas", "Registrar nova vacina no sistema (RF03/RF11)", AZUL_PRINCIPAL, Color.WHITE);
        
        // Ações Secundárias ou Vistas Gerais
        addButton(mainPanel, "Visão Geral Pacientes", "Ver lista de pacientes atendidos (Visão Geral)", CINZA_TEXTO, Color.WHITE);
        addButton(mainPanel, "Pendências", "Visualizar tarefas e alertas de estoque", CINZA_TEXTO, Color.WHITE);
        addButton(mainPanel, "Meu Cadastro", "Atualizar informações do profissional", CINZA_TEXTO, Color.WHITE);

        add(mainPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    // Método para criar botões com ação e estilo
    private void addButton(JPanel panel, String text, String tooltip, Color bgColor, Color fgColor) {
        JButton button = new JButton(text);
        button.setToolTipText(tooltip);
        button.setBackground(bgColor);
        button.setForeground(fgColor); 
        button.setFont(new Font("Arial", Font.BOLD, 14));
        
        // Ação simples: Simula o acesso à tela
        button.addActionListener(e -> JOptionPane.showMessageDialog(this, 
                                                                "Função de " + text + " chamada.", 
                                                                "Navegação", 
                                                                JOptionPane.PLAIN_MESSAGE));

        panel.add(button);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Exemplo de execução
            new DashboardProfissionalSaude("Clayton Banze");
        });
    }
}
