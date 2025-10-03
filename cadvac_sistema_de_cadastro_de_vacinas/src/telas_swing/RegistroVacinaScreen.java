package telas_swing;
import javax.swing.*;
import java.awt.*;

public class RegistroVacinaScreen extends JFrame {
    public RegistroVacinaScreen(){
        setTitle("Registrar Vacina");
        setSize(500,360);
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

        gbc.gridx=0; gbc.gridy=0; p.add(new JLabel("Nome:"), gbc);
        gbc.gridx=1; JTextField nome = new JTextField(20); p.add(nome, gbc);

        gbc.gridx=0; gbc.gridy++; p.add(new JLabel("Fabricante:"), gbc);
        gbc.gridx=1; JTextField fab = new JTextField(20); p.add(fab, gbc);

        gbc.gridx=0; gbc.gridy++; p.add(new JLabel("Validade (YYYY-MM-DD):"), gbc);
        gbc.gridx=1; JTextField val = new JTextField(20); p.add(val, gbc);

        gbc.gridx=0; gbc.gridy++; p.add(new JLabel("Quantidade:"), gbc);
        gbc.gridx=1; JTextField qtd = new JTextField(20); p.add(qtd, gbc);

        gbc.gridx=0; gbc.gridy++; gbc.gridwidth=2; JButton salvar = new JButton("Salvar");
        salvar.addActionListener(e -> JOptionPane.showMessageDialog(this, "Vacina registrada (demo).", "Sucesso", JOptionPane.INFORMATION_MESSAGE));
        p.add(salvar, gbc);

        add(p);
    }
}
