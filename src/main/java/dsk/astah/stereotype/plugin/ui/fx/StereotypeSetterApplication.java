package dsk.astah.stereotype.plugin.ui.fx;

import java.io.IOException;
import java.io.InputStream;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StereotypeSetterApplication extends Application {

    private static final String FXML_FILE = "dsk/astah/stereotype/plugin/ui/fx/StereotypeSetter.fxml";

    private ClassLoader classLoader;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(this.createScene());
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public Scene createScene() throws IOException {
        if (this.classLoader == null) {
            this.classLoader = this.getClass().getClassLoader();
        }
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setClassLoader(classLoader);
        // TODO
        //loader.setResources(ResourceBundle.getBundle("fx_message"));
        try (InputStream is = classLoader.getResource(FXML_FILE).openConnection().getInputStream()) {
            fxmlLoader.load(is);
//            ColorPickerController controller = loader.getController();
            Parent root = fxmlLoader.getRoot();
            Scene scene = new Scene(root);
            return scene;
        }
    }

    public void setClassLoader(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    public static void main(String[] args) {
        Application.launch(StereotypeSetterApplication.class);
    }
}
