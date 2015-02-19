package dsk.astah.stereotype.plugin.ui.fx;

import dsk.astah.stereotype.plugin.service.StereotypeService;
import dsk.astah.stereotype.plugin.ui.swing.SwingStereotypeService;
import java.awt.EventQueue;

public class FxStereotypeService implements StereotypeService {

    private final StereotypeService stereotypeService = new SwingStereotypeService();

    @Override
    public void addStereotype(final String name) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                stereotypeService.addStereotype(name);
            }
        });
    }

    @Override
    public void removeStereotype(final String name) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                stereotypeService.removeStereotype(name);
            }
        });
    }
}
