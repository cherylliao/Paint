package controller;

//import Command.Redo;
//import Command.Undo;
import model.interfaces.IApplicationState;
import view.EventName;
import view.interfaces.IUiModule;
import Command.IStartandEndPoint;
import Command.RedoCommand;
import Command.UndoCommand;

public class JPaintController implements IJPaintController {
    private final IUiModule uiModule;
    private final IApplicationState applicationState;
    IStartandEndPoint Undo;
    IStartandEndPoint Redo;
    IStartandEndPoint Copy;
    
    
    
    public JPaintController(IUiModule uiModule, IApplicationState applicationState) {
        this.uiModule = uiModule;
        this.applicationState = applicationState;
      Undo = new UndoCommand();
      Redo=new RedoCommand();  
      
    }

    @Override
    public void setup() {
        setupEvents();
    }

    private void setupEvents() {
        uiModule.addEvent(EventName.CHOOSE_SHAPE, () -> applicationState.setActiveShape());
        uiModule.addEvent(EventName.CHOOSE_PRIMARY_COLOR, () -> applicationState.setActivePrimaryColor());
        uiModule.addEvent(EventName.CHOOSE_SECONDARY_COLOR, () -> applicationState.setActiveSecondaryColor());
        uiModule.addEvent(EventName.CHOOSE_SHADING_TYPE, () -> applicationState.setActiveShadingType());
        uiModule.addEvent(EventName.CHOOSE_START_POINT_ENDPOINT_MODE, () -> applicationState.setActiveStartAndEndPointMode());
        uiModule.addEvent(EventName.CHOOSE_SHAPE, () -> applicationState.setActiveShape());
        uiModule.addEvent(EventName.UNDO, ()->Undo.run());
        uiModule.addEvent(EventName.REDO,()->Redo.run());
        
       
    }
}

