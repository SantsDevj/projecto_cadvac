package telas_swing;
import javax.swing.*;
import java.awt.*;

public class AlertasScreen extends JFrame {
    public AlertasScreen(){
        setTitle("Alertas");
        setSize(480,360);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        initUI();
    }
    private void initUI(){
        DefaultListModel<String> lm = new DefaultListModel<>();
        lm.addElement("Vacina A: Próxima dose em 2025-10-10");
        lm.addElement("Vacina B: Renovar em 2026-03-01");
        JList<String> list = new JList<>(lm);
        add(new JScrollPane(list));
    }
}
