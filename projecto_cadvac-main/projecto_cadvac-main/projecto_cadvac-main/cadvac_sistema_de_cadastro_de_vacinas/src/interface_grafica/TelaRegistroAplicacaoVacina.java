package interface_grafica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaRegistroAplicacaoVacina extends JFrame {

    // Paleta de Cores (Baseada no documento de Interface)
    private final Color AZUL_PRINCIPAL = new Color(0, 51, 102);     // #003366 (Cabeçalho/Primário)
    private final Color AZUL_CLARO_FUNDO = new Color(230, 240, 245); // #E6F0F5 (Fundo leve)
    private final Color AMARELO_DESTAQUE = new Color(255, 191, 0);   // Amarelo do Logo (Botão de Salvar)
    private final Color CINZA_TEXTO = new Color(51, 51, 51);        // #333333 (Textos)

    public TelaRegistroAplicacaoVacina() {
        // 1. Configuração da Janela
        setTitle("CadVac - Registro de Aplicação de Vacina");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        getContentPane().setBackground(AZUL_CLARO_FUNDO);

        // 2. Painel Superior (Cabeçalho/Título)
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(AZUL_PRINCIPAL);
        JLabel titleLabel = new JLabel("REGISTRO DE APLICAÇÃO DE VACINA (RF03)");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        headerPanel.add(titleLabel);
        add(headerPanel, BorderLayout.NORTH);

        // 3. Painel Central (Formulário)
        JPanel formPanel = new JPanel(new GridLayout(5, 2, 15, 15)); // Layout simples 5x2
        formPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        formPanel.setBackground(AZUL_CLARO_FUNDO);

        // Componentes do Formulário (Requisitos: Paciente, Vacina, Lote, Dose, Local)

        // Paciente (Simulando uma busca por ID ou Cartão de Saúde)
        JLabel pacienteLabel = new JLabel("ID/Cartão de Saúde do Paciente:");
        pacienteLabel.setForeground(CINZA_TEXTO);
        JTextField pacienteField = new JTextField(20);

        // Vacina (Simulando uma seleção de vacinas disponíveis no estoque)
        JLabel vacinaLabel = new JLabel("Vacina Aplicada:");
        vacinaLabel.setForeground(CINZA_TEXTO);
        String[] vacinas = {"COVID-19", "Tétano", "Sarampo", "Gripe H1N1"};
        JComboBox<String> vacinaCombo = new JComboBox<>(vacinas);

        // Lote
        JLabel loteLabel = new JLabel("Número do Lote:");
        loteLabel.setForeground(CINZA_TEXTO);
        JTextField loteField = new JTextField(20);

        // Dose
        JLabel doseLabel = new JLabel("Dose (1ª, 2ª, Reforço, etc.):");
        doseLabel.setForeground(CINZA_TEXTO);
        String[] doses = {"1ª Dose", "2ª Dose", "Dose Única", "Reforço"};
        JComboBox<String> doseCombo = new JComboBox<>(doses);

        // Local da Aplicação
        JLabel localLabel = new JLabel("Local da Aplicação:");
        localLabel.setForeground(CINZA_TEXTO);
        JTextField localField = new JTextField(20);

        // Adiciona componentes ao formulário
        formPanel.add(pacienteLabel);
        formPanel.add(pacienteField);
        formPanel.add(vacinaLabel);
        formPanel.add(vacinaCombo);
        formPanel.add(loteLabel);
        formPanel.add(loteField);
        formPanel.add(doseLabel);
        formPanel.add(doseCombo);
        formPanel.add(localLabel);
        formPanel.add(localField);

        add(formPanel, BorderLayout.CENTER);

        // 4. Painel Inferior (Botões de Ação)
        JPanel footerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        footerPanel.setBackground(AZUL_CLARO_FUNDO);

        JButton registrarButton = new JButton("Registrar Aplicação");
        registrarButton.setBackground(AMARELO_DESTAQUE);
        registrarButton.setForeground(AZUL_PRINCIPAL);
        registrarButton.setFont(new Font("Arial", Font.BOLD, 14));
        registrarButton.setPreferredSize(new Dimension(220, 35));

        // Ação simples para Registrar
        registrarButton.addActionListener(e -> {
            String paciente = pacienteField.getText();
            String vacina = (String) vacinaCombo.getSelectedItem();
            
            if (paciente.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, informe o Paciente (ID/Cartão de Saúde).", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
                return;
            }

            JOptionPane.showMessageDialog(this, 
                "Aplicação de '" + vacina + "' registrada para o Paciente " + paciente + " com sucesso!", 
                "Registro Concluído", 
                JOptionPane.INFORMATION_MESSAGE);
            // O sistema real faria o update no histórico do paciente (RF04) e no estoque (RF05)
        });

        JButton limparButton = new JButton("Limpar Campos");
        limparButton.setBackground(new Color(200, 200, 200)); // Cinza claro
        limparButton.setForeground(CINZA_TEXTO);
        limparButton.setFont(new Font("Arial", Font.BOLD, 14));
        limparButton.setPreferredSize(new Dimension(150, 35));
        
        limparButton.addActionListener(e -> {
            pacienteField.setText("");
            loteField.setText("");
            localField.setText("");
            vacinaCombo.setSelectedIndex(0);
            doseCombo.setSelectedIndex(0);
        });

        footerPanel.add(registrarButton);
        footerPanel.add(limparButton);

        add(footerPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TelaRegistroAplicacaoVacina();
        });
    }
}
