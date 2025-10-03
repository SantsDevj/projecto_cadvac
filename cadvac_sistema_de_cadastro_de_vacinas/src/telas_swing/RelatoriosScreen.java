package telas_swing;
import javax.swing.*;
import java.awt.*;

public class RelatoriosScreen extends JFrame {
    public RelatoriosScreen(){
        setTitle("Geração de Relatórios");
        setSize(600,380);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        initUI();
    }
    private void initUI(){
        JPanel p = new JPanel(new GridBagLayout());
        p.setBackground(Colors.AZUL_CLARO);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8,8,8,8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx=0; gbc.gridy=0; p.add(new JLabel("Tipo de Relatório:"), gbc);
        gbc.gridx=1; JComboBox<String> tipo = new JComboBox<>(new String[]{"Resumo de Vacinação","Estoque","Aplicações por Período"}); p.add(tipo, gbc);

        gbc.gridx=0; gbc.gridy++; p.add(new JLabel("Filtro (opcional):"), gbc);
        gbc.gridx=1; JTextField filtro = new JTextField(20); p.add(filtro, gbc);

        gbc.gridx=0; gbc.gridy++; gbc.gridwidth=2; JButton gerar = new JButton("Gerar");
        gerar.addActionListener(e -> JOptionPane.showMessageDialog(this, "Relatório gerado (demo).", "OK", JOptionPane.INFORMATION_MESSAGE));
        p.add(gerar, gbc);

        add(p);
    }
}
