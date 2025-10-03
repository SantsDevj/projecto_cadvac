package telas_swing;

import javax.swing.SwingUtilities;

public class MainLauncher {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new DashboardPaciente().setVisible(true);
        });
    }
}
