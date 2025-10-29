import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaGeracaoRelatorios extends JFrame {

    // Paleta de Cores (Baseada no documento de Interface)
    private final Color AZUL_PRINCIPAL = new Color(0, 51, 102);     // #003366 (Cabeçalho/Primário)
    private final Color AZUL_CLARO_FUNDO = new Color(230, 240, 245); // #E6F0F5 (Fundo leve)
    private final Color CINZA_TEXTO = new Color(51, 51, 51);        // #333333 (Textos)
    private final Color AZUL_ACAO = new Color(0, 102, 204);         // Azul para o botão principal

    // Elementos de Filtro
    private JComboBox<String> tipoRelatorioCombo;
    private JTextField dataInicioField;
    private JTextField dataFimField;
    private JComboBox<String> regiaoCombo;

    public TelaGeracaoRelatorios() {
        // 1. Configuração da Janela
        setTitle("CadVac - Geração de Relatórios (RF07)");
        setSize(550, 450);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        getContentPane().setBackground(AZUL_CLARO_FUNDO);

        // 2. Painel Superior (Cabeçalho/Título)
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(AZUL_PRINCIPAL);
        JLabel titleLabel = new JLabel("FERRAMENTA DE GERAÇÃO DE RELATÓRIOS");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        headerPanel.add(titleLabel);
        add(headerPanel, BorderLayout.NORTH);

        // 3. Painel Central (Formulário de Filtros)
        JPanel formPanel = new JPanel(new GridLayout(5, 2, 15, 15)); // Layout simples 5x2
        formPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        formPanel.setBackground(AZUL_CLARO_FUNDO);

        // Componentes do Formulário (Requisitos: Tipo, Data Início/Fim, Região)

        // Tipo de Relatório
        JLabel tipoRelatorioLabel = new JLabel("Tipo de Relatório:");
        tipoRelatorioLabel.setForeground(CINZA_TEXTO);
        String[] relatorios = {"Cobertura Vacinal por Faixa Etária", "Estoque Atual", "Aplicações por Período", "Vacinas Pendentes (Alertas)"};
        tipoRelatorioCombo = new JComboBox<>(relatorios);

        // Data de Início
        JLabel dataInicioLabel = new JLabel("Período Inicial (dd/mm/aaaa):");
        dataInicioLabel.setForeground(CINZA_TEXTO);
        dataInicioField = new JTextField(20);

        // Data de Fim
        JLabel dataFimLabel = new JLabel("Período Final (dd/mm/aaaa):");
        dataFimLabel.setForeground(CINZA_TEXTO);
        dataFimField = new JTextField(20);

        // Região/Unidade
        JLabel regiaoLabel = new JLabel("Região/Unidade de Saúde:");
        regiaoLabel.setForeground(CINZA_TEXTO);
        String[] regioes = {"Todas", "Unidade Central", "Posto Bairro A", "Clínica Zona Sul"};
        regiaoCombo = new JComboBox<>(regioes);
        
        // Espaçamento (Linha vazia para melhorar a estética)
        JLabel espaco = new JLabel("");
        JLabel espaco2 = new JLabel("");

        // Adiciona componentes ao formulário
        formPanel.add(tipoRelatorioLabel);
        formPanel.add(tipoRelatorioCombo);
        formPanel.add(dataInicioLabel);
        formPanel.add(dataInicioField);
        formPanel.add(dataFimLabel);
        formPanel.add(dataFimField);
        formPanel.add(regiaoLabel);
        formPanel.add(regiaoCombo);
        formPanel.add(espaco);
        formPanel.add(espaco2);


        add(formPanel, BorderLayout.CENTER);

        // 4. Painel Inferior (Botões de Ação)
        JPanel footerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        footerPanel.setBackground(AZUL_CLARO_FUNDO);

        JButton gerarButton = new JButton("Gerar e Exportar Relatório");
        gerarButton.setBackground(AZUL_ACAO);
        gerarButton.setForeground(Color.WHITE);
        gerarButton.setFont(new Font("Arial", Font.BOLD, 14));
        gerarButton.setPreferredSize(new Dimension(250, 35));

        // Ação simples para Gerar Relatório
        gerarButton.addActionListener(e -> {
            String tipo = (String) tipoRelatorioCombo.getSelectedItem();
            String inicio = dataInicioField.getText();
            String fim = dataFimField.getText();

            // Lógica de validação e geração (RF07)
            if (inicio.isEmpty() || fim.isEmpty()) {
                JOptionPane.showMessageDialog(this, 
                    "Por favor, insira o período completo (Início e Fim).", 
                    "Erro de Filtro", 
                    JOptionPane.ERROR_MESSAGE);
                return;
            }

            JOptionPane.showMessageDialog(this, 
                "Relatório de '" + tipo + "' gerado com sucesso para o período de " + inicio + " a " + fim + ".", 
                "Relatório Concluído", 
                JOptionPane.INFORMATION_MESSAGE);
            // O código real executaria a consulta e abriria o relatório (e.g., PDF, CSV)
        });

        footerPanel.add(gerarButton);

        add(footerPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TelaGeracaoRelatorios();
        });
    }
}