import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.Vector;

public class TelaAlertasPendentes extends JFrame {

    // Paleta de Cores (Baseada no documento de Interface)
    private final Color AZUL_PRINCIPAL = new Color(0, 51, 102);     // #003366 (Cabeçalho/Primário)
    private final Color AZUL_CLARO_FUNDO = new Color(230, 240, 245); // #E6F0F5 (Fundo leve)
    private final Color VERDE_SUCESSO = new Color(76, 175, 80);     // #4CAF50 (Para Ações Positivas)
    private final Color VERMELHO_PENDENTE = new Color(217, 83, 79);  // #D9534F (Para Alertas e Pendências)
    private final Color CINZA_TEXTO = new Color(51, 51, 51);        // #333333 (Textos)

    public TelaAlertasPendentes(String nomePaciente) {
        // 1. Configuração da Janela
        setTitle("CadVac - Alertas de Vacinas Pendentes (RF06)");
        setSize(650, 450);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        getContentPane().setBackground(AZUL_CLARO_FUNDO);

        // 2. Painel Superior (Cabeçalho/Título)
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(AZUL_PRINCIPAL);
        JLabel titleLabel = new JLabel("ALERTAS PENDENTES PARA " + nomePaciente.toUpperCase());
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        headerPanel.add(titleLabel);
        add(headerPanel, BorderLayout.NORTH);

        // 3. Painel Central (Lista de Alertas)
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));
        centerPanel.setBackground(AZUL_CLARO_FUNDO);

        // Dados Simulados de Alertas (Vacina e Data Prevista)
        String[][] dadosAlertas = {
            {"Gripe H1N1", "20/11/2025", "Atrasada em 1 mês", "Alta"},
            {"COVID-19 - Reforço", "15/12/2025", "Próxima data sugerida", "Média"},
            {"Tétano", "01/03/2026", "Agendamento futuro", "Baixa"}
        };
        
        // Define as colunas da tabela de alertas
        String[] colunas = {"Vacina", "Data Sugerida", "Status", "Prioridade"};
        
        // Cria o modelo e a tabela
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (String[] alerta : dadosAlertas) {
             listModel.addElement(String.format("• %s: %s | Status: %s (%s)", 
                                                alerta[0], alerta[1], alerta[2], alerta[3]));
        }

        JList<String> alertasList = new JList<>(listModel);
        alertasList.setFont(new Font("Arial", Font.PLAIN, 16));
        alertasList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alertasList.setForeground(CINZA_TEXTO);
        
        // Renderizador personalizado para destacar a prioridade (Simples)
        alertasList.setCellRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                String item = (String) value;
                if (item.contains("Atrasada")) {
                    label.setForeground(VERMELHO_PENDENTE);
                    label.setFont(label.getFont().deriveFont(Font.BOLD));
                } else if (item.contains("Próxima")) {
                    label.setForeground(AZUL_PRINCIPAL);
                } else {
                    label.setForeground(CINZA_TEXTO);
                }
                return label;
            }
        });
        
        JScrollPane scrollPane = new JScrollPane(alertasList);
        scrollPane.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(AZUL_PRINCIPAL),
            "Suas Vacinas Pendentes (RF06)",
            TitledBorder.CENTER,
            TitledBorder.TOP,
            new Font("Arial", Font.BOLD, 14),
            AZUL_PRINCIPAL
        ));
        
        centerPanel.add(scrollPane, BorderLayout.CENTER);
        add(centerPanel, BorderLayout.CENTER);

        // 4. Painel Inferior (Botão de Ação)
        JPanel footerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 15));
        footerPanel.setBackground(AZUL_CLARO_FUNDO);

        JButton agendarButton = new JButton("Agendar Vacinação");
        agendarButton.setBackground(VERDE_SUCESSO);
        agendarButton.setForeground(Color.WHITE);
        agendarButton.setFont(new Font("Arial", Font.BOLD, 14));
        agendarButton.setPreferredSize(new Dimension(200, 35));

        // Ação simples
        agendarButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, 
                "Função 'Agendar' chamada. O paciente será direcionado para o contato ou agendamento online.", 
                "Ação Sugerida", 
                JOptionPane.INFORMATION_MESSAGE);
        });

        footerPanel.add(agendarButton);
        add(footerPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TelaAlertasPendentes("Celestino Magumane");
        });
    }
}