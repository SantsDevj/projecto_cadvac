package telas_swing;
import javax.swing.*;
import java.awt.*;

public class AplicacaoVacinaScreen extends JFrame {
    public AplicacaoVacinaScreen(){
        setTitle("Registrar Aplicação de Vacina");
        setSize(560,380);
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

        gbc.gridx=0; gbc.gridy=0; p.add(new JLabel("Paciente (ID ou Nome):"), gbc);
        gbc.gridx=1; JTextField paciente = new JTextField(20); p.add(paciente, gbc);

        gbc.gridx=0; gbc.gridy++; p.add(new JLabel("Vacina:"), gbc);
        gbc.gridx=1; JComboBox<String> vacina = new JComboBox<>(new String[]{"Hepatite B","Tríplice Viral"}); p.add(vacina, gbc);

        gbc.gridx=0; gbc.gridy++; p.add(new JLabel("Lote:"), gbc);
        gbc.gridx=1; JTextField lote = new JTextField(20); p.add(lote, gbc);

        gbc.gridx=0; gbc.gridy++; p.add(new JLabel("Dose:"), gbc);
        gbc.gridx=1; JTextField dose = new JTextField(20); p.add(dose, gbc);

        gbc.gridx=0; gbc.gridy++; p.add(new JLabel("Local da Aplicação:"), gbc);
        gbc.gridx=1; JTextField local = new JTextField(20); p.add(local, gbc);

        gbc.gridx=0; gbc.gridy++; gbc.gridwidth=2; JButton registrar = new JButton("Registrar Aplicação");
        registrar.addActionListener(e -> JOptionPane.showMessageDialog(this, "Aplicação registrada (demo).", "Sucesso", JOptionPane.INFORMATION_MESSAGE));
        p.add(registrar, gbc);

        add(p);
    }
}
