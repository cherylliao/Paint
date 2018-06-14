package Command;
import java.awt.Point;
import java.util.ArrayList;

import model.interfaces.IApplicationState;
import model.shapes.ShapeClass;
import model.ShapeType;
//how to play around with the lists to make undo redo for move command;
//is this the right idea for move? 
public class MoveShape implements IStartandEndPoint{
	private Point start;
	private Point end;
	private IApplicationState appstate;
	//ArrayList<ShapeClass> oldShapes = new ArrayList<ShapeClass>();
	ArrayList<ShapeClass> newShapes = new ArrayList<ShapeClass>();
	private Collection collection;
	ShapeClass newShape;
	public MoveShape(Point start, Point end, IApplicationState appstate,Collection collection)
	{
		this.start=start;
		this.end=end;
		this.appstate=appstate;
		this.collection=collection;
	
		newShapes=collection.getMovedList();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		collection.Clear();
		newShape=new ShapeClass(start,end,appstate.getActiveShapeType(),
				appstate.getActivePrimaryColor(),appstate.getActiveSecondaryColor(),
				appstate.getActiveShapeShadingType());
		for(ShapeClass e: collection.getSelectedList())
		{
			
				
				newShape=new ShapeClass(start,end,e.getShape(),
						e.getPColor(),e.getSColor(),
						e.getShading());
				
				collection.notify(newShape);
				collection.addMove(newShape);
				
		}
		}
		
		
	
	public void undo() {
		// TODO Auto-generated method stub
		collection.Clear();
		for (ShapeClass e: collection.getInitialList())
		{
			collection.notify(e);
		
			
	}
		
		
	}
	
	//public void redo()
	//{
	//	for (ShapeClass e: collection.getMovedList())
	//	{
			
	//		collection.notify(e);
	//}
		

}

	



