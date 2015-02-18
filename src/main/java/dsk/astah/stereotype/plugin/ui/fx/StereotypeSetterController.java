package dsk.astah.stereotype.plugin.ui.fx;

import dsk.astah.stereotype.plugin.service.StereotypeService;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

public class StereotypeSetterController implements Initializable {

    private final StereotypeService stereotypeService = new FxStereotypeService();

    @FXML
    private TextField inputText;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    protected void addStereotype(ActionEvent e) {
        stereotypeService.addStereotype(this.inputText.getText());
    }

    @FXML
    protected void removeStereotype(ActionEvent e) {
        stereotypeService.removeStereotype(this.inputText.getText());
    }
}
