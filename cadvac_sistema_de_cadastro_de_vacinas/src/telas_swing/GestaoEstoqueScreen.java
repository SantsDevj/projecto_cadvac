package telas_swing;
import javax.swing.*;
import java.awt.*;

public class GestaoEstoqueScreen extends JFrame {
    public GestaoEstoqueScreen(){
        setTitle("Gestão de Estoque");
        setSize(800,420);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        initUI();
    }
    private void initUI(){
        JPanel root = new JPanel(new BorderLayout());
        root.setBackground(Colors.AZUL_CLARO);

        String[] cols = {"Vacina","Lote","Validade","Quantidade"};
        Object[][] data = {{"Hep B","L001","2026-01-01",120}};
        JTable table = new JTable(data, cols);
        root.add(new JScrollPane(table), BorderLayout.CENTER);

        JPanel actions = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton add = new JButton("Adicionar");
        JButton atualizar = new JButton("Atualizar Quantidade");
        JButton remover = new JButton("Remover");
        actions.add(add); actions.add(atualizar); actions.add(remover);
        root.add(actions, BorderLayout.SOUTH);

        add(root);
    }
}
