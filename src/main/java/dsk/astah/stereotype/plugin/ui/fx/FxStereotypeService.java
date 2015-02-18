package dsk.astah.stereotype.plugin.ui.fx;

import dsk.astah.stereotype.plugin.service.StereotypeService;
import dsk.astah.stereotype.plugin.ui.swing.SwingStereotypeService;
import java.awt.EventQueue;

public class FxStereotypeService implements StereotypeService {

    private final StereotypeService stereotypeService = new SwingStereotypeService();

    @Override
    public void addStereotype(String name) {
        EventQueue.invokeLater(() -> {
            stereotypeService.addStereotype(name);
        });
    }

    @Override
    public void removeStereotype(String name) {
        EventQueue.invokeLater(() -> {
            stereotypeService.removeStereotype(name);
        });
    }
}
