package telas_swing;
import javax.swing.*;
import java.awt.*;

public class DashboardGestor extends JFrame {
    public DashboardGestor(){
        setTitle("Dashboard - Gestor");
        setSize(1000,560);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        initUI();
    }
    private void initUI(){
        JPanel root = new JPanel(new BorderLayout());
        root.setBackground(Colors.AZUL_CLARO);
        JLabel header = new JLabel("Painel do Gestor", SwingConstants.LEFT);
        header.setOpaque(true);
        header.setBackground(Colors.AZUL_ESCURO);
        header.setForeground(Color.WHITE);
        header.setFont(header.getFont().deriveFont(Font.BOLD,18f));
        header.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        root.add(header, BorderLayout.NORTH);

        JPanel center = new JPanel(new GridLayout(1,2,10,10));
        center.setOpaque(false);

        JPanel estoque = new JPanel(new BorderLayout());
        estoque.setBorder(BorderFactory.createTitledBorder("Gestão de Estoque"));
        String[] cols = {"Vacina","Lote","Validade","Quantidade"};
        Object[][] data = {{"Hep B","L001","2026-01-01", 120}};
        JTable table = new JTable(data, cols);
        estoque.add(new JScrollPane(table), BorderLayout.CENTER);
        center.add(estoque);

        JPanel rel = new JPanel(new BorderLayout());
        rel.setBorder(BorderFactory.createTitledBorder("Relatórios"));
        JButton gerar = new JButton("Gerar Relatório");
        gerar.addActionListener(e -> new RelatoriosScreen().setVisible(true));
        rel.add(gerar, BorderLayout.NORTH);
        center.add(rel);

        root.add(center, BorderLayout.CENTER);
        add(root);
    }
}
