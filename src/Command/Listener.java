package Command;


import model.interfaces.IApplicationState;
import model.shapes.ShapeClass;
import view.gui.Display;

//listens for static collection and appstate 
//to call methods on display on shapeclass object
//communicates between collection and display. 
public class Listener {

	private IApplicationState appstate;
	private Display display;

	private ShapeClass Shape;
	public Listener(IApplicationState appstate, Display display)
	{
		this.appstate = appstate;
		this.display = display;
		
	}
	public void makeShapeAppear(ShapeClass shape)
	{
		
		 
			display.ShapeAppear(shape);
		
	    
	}
	public void clearScreen()
	{
		display.ClearRectangle();
	}
	
	

	
		
		
		
	}


