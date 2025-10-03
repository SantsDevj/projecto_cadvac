package telas_swing;
import javax.swing.*;
import java.awt.*;

public class HistoricoPacienteScreen extends JFrame {
    public HistoricoPacienteScreen(){
        setTitle("Histórico do Paciente");
        setSize(700,420);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        initUI();
    }
    private void initUI(){
        JPanel root = new JPanel(new BorderLayout());
        root.setBackground(Colors.AZUL_CLARO);
        root.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        String[] cols = {"Vacina","Dose","Data","Local","Profissional"};
        Object[][] data = {
            {"Hepatite B","1ª","2024-02-15","Unidade A","Dr. Silva"},
            {"Tríplice Viral","2ª","2023-11-10","Unidade B","Enf. Costa"}
        };
        JTable table = new JTable(data, cols);
        root.add(new JScrollPane(table), BorderLayout.CENTER);

        add(root);
    }
}
