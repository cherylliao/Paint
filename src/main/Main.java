package main;
import Command.MouseHandler;
import java.awt.event.MouseListener;
import Command.Collection;
import Command.Listener;
import controller.IJPaintController;
import controller.JPaintController;
import model.persistence.ApplicationState;
import model.shapes.ShapeClass;
import view.gui.Display;
import view.gui.Gui;
import view.gui.GuiWindow;
import view.gui.PaintCanvas;
import view.interfaces.IGuiWindow;
import view.interfaces.IUiModule;


public class Main {
    public static void main(String[] args){
	    PaintCanvas paintCanvas = new PaintCanvas();
        IGuiWindow guiWindow = new GuiWindow(paintCanvas);
        IUiModule uiModule = new Gui(guiWindow);
        ApplicationState appState = new ApplicationState(uiModule);
		Display display = new Display(paintCanvas);
	    
        Listener listener = new Listener(appState, display);
        Collection c = new Collection(paintCanvas, listener);
        IJPaintController controller = new JPaintController(uiModule, appState);
        controller.setup();
        paintCanvas.addMouseListener((MouseListener) new MouseHandler(appState, c));
       
    }
}
