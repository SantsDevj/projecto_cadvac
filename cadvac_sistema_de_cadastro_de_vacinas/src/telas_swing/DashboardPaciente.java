package telas_swing;
import javax.swing.*;
import java.awt.*;

public class DashboardPaciente extends JFrame {
    public DashboardPaciente() {
        setTitle("Dashboard - Paciente");
        setSize(800, 520);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        initUI();
    }

    private void initUI() {
        JPanel root = new JPanel(new BorderLayout());
        root.setBackground(Colors.AZUL_CLARO);

        JLabel header = new JLabel("Painel do Paciente", SwingConstants.LEFT);
        header.setOpaque(true);
        header.setBackground(Colors.AZUL_ESCURO);
        header.setForeground(Color.WHITE);
        header.setFont(header.getFont().deriveFont(Font.BOLD, 18f));
        header.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        root.add(header, BorderLayout.NORTH);

        // Center: summary & alerts
        JPanel center = new JPanel(new GridLayout(1,2,10,10));
        center.setOpaque(false);

        JPanel resumo = new JPanel(new BorderLayout());
        resumo.setBorder(BorderFactory.createTitledBorder("Resumo de Vacinação"));
        String[] cols = {"Vacina","Dose","Data","Local"};
        Object[][] data = {
            {"Hepatite B","1ª","2024-02-15","Unidade A"},
            {"Tríplice Viral","2ª","2023-11-10","Unidade B"}
        };
        JTable table = new JTable(data, cols);
        resumo.add(new JScrollPane(table), BorderLayout.CENTER);
        center.add(resumo);

        JPanel alertas = new JPanel(new BorderLayout());
        alertas.setBorder(BorderFactory.createTitledBorder("Alertas Pendentes"));
        DefaultListModel<String> lm = new DefaultListModel<>();
        lm.addElement("Vacina X: 1 dose restante");
        lm.addElement("Vacina Y: Renovar em 2026-05-01");
        JList<String> list = new JList<>(lm);
        alertas.add(new JScrollPane(list), BorderLayout.CENTER);
        center.add(alertas);

        root.add(center, BorderLayout.CENTER);

        // Footer with actions
        JPanel footer = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton verHistorico = new JButton("Ver Histórico");
        verHistorico.addActionListener(e -> new HistoricoPacienteScreen().setVisible(true));
        footer.add(verHistorico);
        root.add(footer, BorderLayout.SOUTH);

        add(root);
    }
}
