package dsk.astah.stereotype.plugin.action;

import com.change_vision.jude.api.inf.ui.IPluginActionDelegate;
import com.change_vision.jude.api.inf.ui.IWindow;
import dsk.astah.stereotype.plugin.ui.fx.StereoTypeSetterWindow;

public class StereoTypeSetterAction implements IPluginActionDelegate {

    @Override
    public Object run(IWindow window) throws UnExpectedException {
        StereoTypeSetterWindow stereotypeSetter = new StereoTypeSetterWindow();
        stereotypeSetter.setVisible(true);
        return null;
    }
}
