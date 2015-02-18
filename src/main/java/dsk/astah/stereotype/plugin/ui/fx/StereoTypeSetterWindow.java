package dsk.astah.stereotype.plugin.ui.fx;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.io.IOException;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javax.swing.JFrame;

public class StereoTypeSetterWindow extends JFrame {

    public StereoTypeSetterWindow() {
        this.initComponents();
    }

    private void initComponents() {
        this.setSize(new Dimension(364, 138));
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        final JFXPanel panel = new JFXPanel();
        this.add(panel);
        final StereotypeSetterApplication app = new StereotypeSetterApplication();
        app.setClassLoader(this.getClass().getClassLoader());
        Platform.runLater(() -> {
            try {
                panel.setScene(app.createScene());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            StereoTypeSetterWindow window = new StereoTypeSetterWindow();
            window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            window.setVisible(true);
        });
    }
}
