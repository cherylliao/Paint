package Command;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.interfaces.IApplicationState;
import view.gui.Display;
public class MouseHandler extends MouseAdapter{
	
/*	StartAndEndPointMode DRAW;
	StartAndEndPointMode SELECT;*/
	private IApplicationState appState;
	private Point start;
	private Point end;
    
	private Collection collection;
	
	public MouseHandler(IApplicationState appState, Collection collection)
	{
		this.appState=appState;
		this.collection = collection;
	}
	//the statements for colors and shades;
	public void mousePressed(MouseEvent e)
	{   start=e.getPoint();
	    
		
	}
	
	public void mouseReleased(MouseEvent e)
	{
		end=e.getPoint();
		
		IStartandEndPoint startEndPointCommand = null;
		
		switch(appState.getActiveStartAndEndPointMode()) {
		case DRAW:
			startEndPointCommand = new createShape(start, end, appState, collection);
			break;
		case MOVE:
			startEndPointCommand = new MoveShape(start, end, appState,collection);
			break;
		case SELECT:
			
			startEndPointCommand = new SelectShape(start, end, appState,collection);
			break;
		//default:
			//throw new Exception("Invalid start and end point");*/
		default:
			break;
		}
		
		startEndPointCommand.run();
		
	}

	
		
	

}

	
		
	


