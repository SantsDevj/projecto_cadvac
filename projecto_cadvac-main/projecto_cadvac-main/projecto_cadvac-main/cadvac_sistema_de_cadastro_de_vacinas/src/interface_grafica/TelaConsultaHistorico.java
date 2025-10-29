package interface_grafica;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaConsultaHistorico extends JFrame {

    // Paleta de Cores (Baseada no documento de Interface)
    private final Color AZUL_PRINCIPAL = new Color(0, 51, 102);     // #003366 (Cabeçalho/Primário)
    private final Color AZUL_CLARO_FUNDO = new Color(230, 240, 245); // #E6F0F5 (Fundo leve)
    private final Color CINZA_TEXTO = new Color(51, 51, 51);        // #333333 (Textos)
    private final Color AZUL_ACAO = new Color(0, 102, 204);         // Azul para o botão de Pesquisar

    private JTable historicoTable;
    private DefaultTableModel tableModel;
    private JTextField pesquisaField;

    public TelaConsultaHistorico() {
        // 1. Configuração da Janela
        setTitle("CadVac - Consulta de Histórico Vacinal (RF04)");
        setSize(800, 550);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        getContentPane().setBackground(AZUL_CLARO_FUNDO);

        // 2. Painel Superior (Cabeçalho/Título)
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(AZUL_PRINCIPAL);
        JLabel titleLabel = new JLabel("HISTÓRICO DE VACINAÇÃO DO PACIENTE");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        headerPanel.add(titleLabel);
        add(headerPanel, BorderLayout.NORTH);

        // 3. Painel de Pesquisa (Top Center)
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 15));
        searchPanel.setBackground(AZUL_CLARO_FUNDO);
        
        JLabel pesquisaLabel = new JLabel("ID/Cartão de Saúde do Paciente:");
        pesquisaLabel.setForeground(CINZA_TEXTO);
        pesquisaField = new JTextField(25);
        
        JButton pesquisarButton = new JButton("Pesquisar");
        pesquisarButton.setBackground(AZUL_ACAO);
        pesquisarButton.setForeground(Color.WHITE);
        pesquisarButton.setFont(new Font("Arial", Font.BOLD, 12));
        
        // Ação de Pesquisa
        pesquisarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Simulação: Limpa a tabela e adiciona dados simulados com base na pesquisa
                carregarDadosSimulados(pesquisaField.getText());
            }
        });

        searchPanel.add(pesquisaLabel);
        searchPanel.add(pesquisaField);
        searchPanel.add(pesquisarButton);

        // 4. Painel Central (Tabela de Histórico)
        
        // Define as colunas da tabela
        String[] colunas = {"Vacina", "Dose", "Data de Aplicação", "Local/Hospital", "Lote", "Profissional"};
        tableModel = new DefaultTableModel(colunas, 0); // 0 linhas iniciais
        historicoTable = new JTable(tableModel);
        
        // Configuração simples da tabela
        historicoTable.setBackground(Color.WHITE);
        historicoTable.setRowHeight(25);
        historicoTable.setFont(new Font("Arial", Font.PLAIN, 12));
        
        JScrollPane scrollPane = new JScrollPane(historicoTable);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));
        
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.add(searchPanel, BorderLayout.NORTH);
        centerPanel.add(scrollPane, BorderLayout.CENTER);
        centerPanel.setBackground(AZUL_CLARO_FUNDO);

        add(centerPanel, BorderLayout.CENTER);

        // Carrega dados iniciais vazios ou de um paciente padrão
        carregarDadosSimulados(""); 

        setVisible(true);
    }

    // Método que simula o carregamento dos dados do histórico (RF04)
    private void carregarDadosSimulados(String idPaciente) {
        // Limpa a tabela
        tableModel.setRowCount(0); 

        if (idPaciente.trim().isEmpty()) {
            // Mensagem se a pesquisa estiver vazia
            pesquisaField.setText("Digite um ID para buscar o Histórico.");
            return;
        }

        // Simulação de dados (dados reais viriam do banco de dados)
        if (idPaciente.contains("123")) {
            tableModel.addRow(new Object[]{"Tétano", "Dose Única", "10/01/2023", "Hospital Central", "L4578", "Dr. João"});
            tableModel.addRow(new Object[]{"Gripe H1N1", "1ª Dose", "15/05/2023", "Clínica Saúde Já", "G9901", "Dra. Ana"});
            tableModel.addRow(new Object[]{"COVID-19", "2ª Dose", "20/09/2023", "Posto Municipal", "C002B", "Enf. Maria"});
        } else {
            // Caso não encontre
            tableModel.addRow(new Object[]{"Nenhum histórico encontrado para o ID: " + idPaciente, "", "", "", "", ""});
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TelaConsultaHistorico();
        });
    }
}