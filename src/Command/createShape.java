package Command;

import java.awt.Point;
import model.interfaces.IApplicationState;
import model.shapes.ShapeClass;

//when we are in draw mode;
public class createShape implements IStartandEndPoint,IUndoable{
	private Point start;
	private Point end;
	private IApplicationState appstate;
	
	ShapeClass shape;
	private Collection collection;

	public createShape(Point start, Point end, IApplicationState appstate, Collection collection)
	{
		this.start=start;
		this.end=end;
		this.appstate=appstate;
		this.collection = collection;
	}
	public void run() {
		shape=new ShapeClass(start,end,appstate.getActiveShapeType(),
		appstate.getActivePrimaryColor(),appstate.getActiveSecondaryColor(),
		appstate.getActiveShapeShadingType());
        collection.notify(shape);
		collection.addInitial(shape);
		CommandHistory.add(this);
		
	}
	public void undo()
	{
		collection.deleteInitialList(shape);

	}
	public void redo()
	{
		collection.addInitial(shape);
		collection.notify(shape);
	}
	
     
}
