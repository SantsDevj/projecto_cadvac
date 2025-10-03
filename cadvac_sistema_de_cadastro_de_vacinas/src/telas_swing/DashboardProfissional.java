package telas_swing;
import javax.swing.*;
import java.awt.*;


public class DashboardProfissional extends JFrame {
    public DashboardProfissional() {
        setTitle("Dashboard - Profissional de Saúde");
        setSize(900,520);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        initUI();
    }
    private void initUI(){
        JPanel root = new JPanel(new BorderLayout());
        root.setBackground(Colors.AZUL_CLARO);

        JLabel header = new JLabel("Painel do Profissional", SwingConstants.LEFT);
        header.setOpaque(true);
        header.setBackground(Colors.AZUL_ESCURO);
        header.setForeground(Color.WHITE);
        header.setFont(header.getFont().deriveFont(Font.BOLD,18f));
        header.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        root.add(header, BorderLayout.NORTH);

        JPanel center = new JPanel(new GridLayout(1,2,10,10));
        center.setOpaque(false);

        JPanel regVac = new JPanel(new BorderLayout());
        regVac.setBorder(BorderFactory.createTitledBorder("Registrar Vacina"));
        JButton abrirRegistro = new JButton("Abrir Tela de Registro");
        abrirRegistro.addActionListener(e -> new RegistroVacinaScreen().setVisible(true));
        regVac.add(abrirRegistro, BorderLayout.NORTH);
        center.add(regVac);

        JPanel aplicar = new JPanel(new BorderLayout());
        aplicar.setBorder(BorderFactory.createTitledBorder("Registrar Aplicação"));
        JButton abrirAplic = new JButton("Abrir Tela de Aplicação");
        abrirAplic.addActionListener(e -> new AplicacaoVacinaScreen().setVisible(true));
        aplicar.add(abrirAplic, BorderLayout.NORTH);
        center.add(aplicar);

        root.add(center, BorderLayout.CENTER);

        add(root);
    }
}
