package interface_grafica;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TelaGestaoEstoque extends JFrame {

    // Paleta de Cores (Baseada no documento de Interface)
    private final Color AZUL_PRINCIPAL = new Color(0, 51, 102);     // #003366 (Cabeçalho/Primário)
    private final Color AMARELO_DESTAQUE = new Color(255, 191, 0);   // Amarelo do Logo (Botão principal)
    private final Color AZUL_CLARO_FUNDO = new Color(230, 240, 245); // #E6F0F5 (Fundo leve)
    private final Color CINZA_TEXTO = new Color(51, 51, 51);        // #333333 (Textos)
    private final Color VERMELHO_AVISO = new Color(217, 83, 79);    // Vermelho para remover

    private JTable estoqueTable;
    private DefaultTableModel tableModel;

    public TelaGestaoEstoque() {
        // 1. Configuração da Janela
        setTitle("CadVac - Gestão de Estoque de Vacinas (RF05)");
        setSize(850, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        getContentPane().setBackground(AZUL_CLARO_FUNDO);

        // 2. Painel Superior (Cabeçalho/Título)
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(AZUL_PRINCIPAL);
        JLabel titleLabel = new JLabel("GESTÃO DE ESTOQUE DE VACINAS");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        headerPanel.add(titleLabel);
        add(headerPanel, BorderLayout.NORTH);

        // 3. Painel Central (Tabela de Estoque)
        
        // Define as colunas da tabela
        String[] colunas = {"ID", "Vacina", "Fabricante", "Validade", "Lotes Ativos", "Qtd. Disponível"};
        tableModel = new DefaultTableModel(colunas, 0); // 0 linhas iniciais
        estoqueTable = new JTable(tableModel);
        
        // Configuração simples da tabela
        estoqueTable.setBackground(Color.WHITE);
        estoqueTable.setRowHeight(25);
        estoqueTable.setFont(new Font("Arial", Font.PLAIN, 12));
        
        JScrollPane scrollPane = new JScrollPane(estoqueTable);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        
        // Adiciona dados simulados iniciais
        carregarDadosSimulados();
        
        add(scrollPane, BorderLayout.CENTER);

        // 4. Painel Inferior (Botões de Ação de Gestão)
        JPanel footerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 25, 15));
        footerPanel.setBackground(AZUL_CLARO_FUNDO);

        // Botão para adicionar nova vacina (Requer RF03)
        JButton adicionarButton = new JButton("Adicionar Nova Vacina");
        adicionarButton.setBackground(AZUL_PRINCIPAL);
        adicionarButton.setForeground(Color.WHITE);
        adicionarButton.setFont(new Font("Arial", Font.BOLD, 14));
        adicionarButton.setPreferredSize(new Dimension(220, 35));

        // Botão para dar entrada de doses (Atualizar Qtd.)
        JButton entradaButton = new JButton("Dar Entrada de Doses");
        entradaButton.setBackground(AMARELO_DESTAQUE);
        entradaButton.setForeground(AZUL_PRINCIPAL);
        entradaButton.setFont(new Font("Arial", Font.BOLD, 14));
        entradaButton.setPreferredSize(new Dimension(200, 35));

        // Botão para remover vacina/Lote
        JButton removerButton = new JButton("Remover/Descartar");
        removerButton.setBackground(VERMELHO_AVISO);
        removerButton.setForeground(Color.WHITE);
        removerButton.setFont(new Font("Arial", Font.BOLD, 14));
        removerButton.setPreferredSize(new Dimension(200, 35));
        
        // Ações dos Botões (Simulação)
        adicionarButton.addActionListener(e -> JOptionPane.showMessageDialog(this, 
            "Função 'Adicionar Nova Vacina' chamada (Abre Tela RF03).", 
            "Ação", 
            JOptionPane.PLAIN_MESSAGE));

        entradaButton.addActionListener(e -> JOptionPane.showMessageDialog(this, 
            "Função 'Dar Entrada' chamada. Abre formulário para inserir Lote e Quantidade.", 
            "Ação", 
            JOptionPane.PLAIN_MESSAGE));
        
        removerButton.addActionListener(e -> {
            int selectedRow = estoqueTable.getSelectedRow();
            if (selectedRow >= 0) {
                // Simulação de remoção/descarte
                String nomeVacina = (String) tableModel.getValueAt(selectedRow, 1);
                JOptionPane.showMessageDialog(this, 
                    "Vacina '" + nomeVacina + "' removida ou marcada para descarte.", 
                    "Ação", 
                    JOptionPane.WARNING_MESSAGE);
                // tableModel.removeRow(selectedRow); // O código real faria o update no DB
            } else {
                 JOptionPane.showMessageDialog(this, "Selecione uma linha para remover/descartar.", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        });


        footerPanel.add(adicionarButton);
        footerPanel.add(entradaButton);
        footerPanel.add(removerButton);

        add(footerPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    // Método que simula o carregamento dos dados do estoque (RF05)
    private void carregarDadosSimulados() {
        tableModel.addRow(new Object[]{1, "COVID-19 - Pfizer", "Pfizer", "30/12/2026", 5, 1500});
        tableModel.addRow(new Object[]{2, "Tétano", "BioNTech", "01/05/2025", 2, 850});
        tableModel.addRow(new Object[]{3, "Sarampo", "GSK", "10/08/2024", 1, 30}); // Baixo estoque
        tableModel.addRow(new Object[]{4, "Gripe H1N1", "Sanofi", "15/03/2026", 4, 1200});
        tableModel.addRow(new Object[]{5, "Hepatite B", "Merck", "25/11/2025", 3, 900});
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TelaGestaoEstoque();
        });
    }
}