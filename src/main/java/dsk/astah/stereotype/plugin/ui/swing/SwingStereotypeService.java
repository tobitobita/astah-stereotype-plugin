package dsk.astah.stereotype.plugin.ui.swing;

import com.change_vision.jude.api.inf.AstahAPI;
import com.change_vision.jude.api.inf.editor.TransactionManager;
import com.change_vision.jude.api.inf.exception.InvalidEditingException;
import com.change_vision.jude.api.inf.exception.InvalidUsingException;
import com.change_vision.jude.api.inf.view.IDiagramViewManager;
import dsk.astah.stereotype.plugin.service.StereotypeService;
import java.util.Arrays;

public class SwingStereotypeService implements StereotypeService {

    @Override
    public void addStereotype(String name) {
        TransactionManager.beginTransaction();
        try {
            IDiagramViewManager diagramViewManager = AstahAPI.getAstahAPI().getViewManager().getDiagramViewManager();
            Arrays.stream(diagramViewManager.getSelectedElements()).forEach(element -> {
                try {
                    element.addStereotype(name);
                } catch (InvalidEditingException e) {
                    e.printStackTrace();
                }
            });
            TransactionManager.endTransaction();
        } catch (InvalidUsingException | ClassNotFoundException e) {
            TransactionManager.abortTransaction();
            e.printStackTrace();
        }
    }

    @Override
    public void removeStereotype(String name) {
        TransactionManager.beginTransaction();
        try {
            IDiagramViewManager diagramViewManager = AstahAPI.getAstahAPI().getViewManager().getDiagramViewManager();
            Arrays.stream(diagramViewManager.getSelectedElements()).forEach(element -> {
                try {
                    element.removeStereotype(name);
                } catch (InvalidEditingException e) {
                    e.printStackTrace();
                }
            });
            TransactionManager.endTransaction();
        } catch (InvalidUsingException | ClassNotFoundException e) {
            TransactionManager.abortTransaction();
            e.printStackTrace();
        }
    }
}
