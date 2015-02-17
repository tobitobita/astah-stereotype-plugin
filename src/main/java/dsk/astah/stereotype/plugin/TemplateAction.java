package dsk.astah.stereotype.plugin;

import com.change_vision.jude.api.inf.AstahAPI;
import com.change_vision.jude.api.inf.editor.TransactionManager;
import com.change_vision.jude.api.inf.exception.InvalidEditingException;
import com.change_vision.jude.api.inf.exception.InvalidUsingException;
import com.change_vision.jude.api.inf.model.INamedElement;
import com.change_vision.jude.api.inf.ui.IPluginActionDelegate;
import com.change_vision.jude.api.inf.ui.IWindow;
import com.change_vision.jude.api.inf.view.IDiagramViewManager;
import java.util.Arrays;

public class TemplateAction implements IPluginActionDelegate {

    @Override
    public Object run(IWindow window) throws UnExpectedException {
        System.out.println("run");
        TransactionManager.beginTransaction();
        try {
            IDiagramViewManager diagramViewManager = AstahAPI.getAstahAPI().getViewManager().getDiagramViewManager();
            Arrays.stream(diagramViewManager.getSelectedElements()).forEach(element -> {
                if (element instanceof INamedElement) {
                    INamedElement namedElement = (INamedElement) element;
                    System.out.println(namedElement.getName());
                }
                try {
                    element.addStereotype("aaa");
                } catch (InvalidEditingException e) {
                    e.printStackTrace();
                }
            });
            TransactionManager.endTransaction();
        } catch (InvalidUsingException | ClassNotFoundException e) {
            TransactionManager.abortTransaction();
            e.printStackTrace();
        }
        return null;
    }
}
