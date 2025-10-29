package interface_grafica;

import javax.swing.*;
import java.awt.*;

public class TelaRegistroVacina extends JFrame {

    // Paleta de Cores (Baseada no documento de Interface)
    private final Color AZUL_PRINCIPAL = new Color(0, 51, 102);     // #003366 (Cabeçalho/Primário)
    private final Color AZUL_CLARO_FUNDO = new Color(230, 240, 245); // #E6F0F5 (Fundo leve)
    private final Color VERDE_SUCESSO = new Color(76, 175, 80);     // #4CAF50 (Botão de Salvar)
    private final Color CINZA_TEXTO = new Color(51, 51, 51);        // #333333 (Textos)

    public TelaRegistroVacina() {
        // 1. Configuração da Janela
        setTitle("CadVac - Registro de Nova Vacina");
        setSize(550, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Fechar apenas esta janela
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        getContentPane().setBackground(AZUL_CLARO_FUNDO);

        // 2. Painel Superior (Cabeçalho/Título)
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(AZUL_PRINCIPAL);
        JLabel titleLabel = new JLabel("REGISTRO DE NOVA VACINA");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        headerPanel.add(titleLabel);
        add(headerPanel, BorderLayout.NORTH);

        // 3. Painel Central (Formulário)
        JPanel formPanel = new JPanel(new GridLayout(4, 2, 15, 15)); // Layout simples 4x2
        formPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        formPanel.setBackground(AZUL_CLARO_FUNDO);

        // Componentes do Formulário (Requisitos: Nome, Fabricante, Validade, Quantidade)

        // Nome da Vacina
        JLabel nomeLabel = new JLabel("Nome da Vacina:");
        nomeLabel.setForeground(CINZA_TEXTO);
        JTextField nomeField = new JTextField(20);

        // Fabricante
        JLabel fabricanteLabel = new JLabel("Fabricante:");
        fabricanteLabel.setForeground(CINZA_TEXTO);
        JTextField fabricanteField = new JTextField(20);

        // Data de Validade
        JLabel validadeLabel = new JLabel("Data de Validade (dd/mm/aaaa):");
        validadeLabel.setForeground(CINZA_TEXTO);
        JTextField validadeField = new JTextField(20);

        // Quantidade Disponível (Estoque Inicial)
        JLabel quantidadeLabel = new JLabel("Quantidade Disponível (Doses):");
        quantidadeLabel.setForeground(CINZA_TEXTO);
        JTextField quantidadeField = new JTextField(20);

        // Adiciona componentes ao formulário
        formPanel.add(nomeLabel);
        formPanel.add(nomeField);
        formPanel.add(fabricanteLabel);
        formPanel.add(fabricanteField);
        formPanel.add(validadeLabel);
        formPanel.add(validadeField);
        formPanel.add(quantidadeLabel);
        formPanel.add(quantidadeField);

        add(formPanel, BorderLayout.CENTER);

        // 4. Painel Inferior (Botões de Ação)
        JPanel footerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        footerPanel.setBackground(AZUL_CLARO_FUNDO);

        JButton salvarButton = new JButton("Salvar Registro (RF03)");
        salvarButton.setBackground(VERDE_SUCESSO);
        salvarButton.setForeground(Color.WHITE);
        salvarButton.setFont(new Font("Arial", Font.BOLD, 14));
        salvarButton.setPreferredSize(new Dimension(200, 35));

        // Ação simples para Salvar
        salvarButton.addActionListener(e -> {
            // Lógica de validação e salvamento seria implementada aqui (RF03)
            String nome = nomeField.getText();
            String fabricante = fabricanteField.getText();

            JOptionPane.showMessageDialog(this, 
                "Vacina '" + nome + "' do fabricante '" + fabricante + "' registrada com sucesso!", 
                "Registro Concluído", 
                JOptionPane.INFORMATION_MESSAGE);
            // Poderia fechar a janela ou limpar os campos após o sucesso
        });

        JButton limparButton = new JButton("Limpar Campos");
        limparButton.setBackground(new Color(200, 200, 200)); // Cinza claro
        limparButton.setForeground(CINZA_TEXTO);
        limparButton.setFont(new Font("Arial", Font.BOLD, 14));
        limparButton.setPreferredSize(new Dimension(150, 35));
        
        limparButton.addActionListener(e -> {
            nomeField.setText("");
            fabricanteField.setText("");
            validadeField.setText("");
            quantidadeField.setText("");
        });

        footerPanel.add(salvarButton);
        footerPanel.add(limparButton);

        add(footerPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TelaRegistroVacina();
        });
    }
}