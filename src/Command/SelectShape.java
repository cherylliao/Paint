package Command;
import java.awt.Point;
import model.interfaces.IApplicationState;
import model.shapes.ShapeClass;
import model.ShapeType;
public class SelectShape implements IStartandEndPoint{
	private Point start;
	private Point end;
	private IApplicationState appstate;
	ShapeType RECTANGLE;
	ShapeClass newRectangle;
	private Collection collection;
	public SelectShape(Point start, Point end, IApplicationState appstate,Collection collection)
	{
		this.start=start;
		this.end=end;
		this.appstate=appstate;
		this.collection = collection;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		newRectangle=new ShapeClass(start,end,appstate.getActiveShapeType(),
				appstate.getActivePrimaryColor(),appstate.getActiveSecondaryColor(),
				appstate.getActiveShapeShadingType());
	
		
		for(ShapeClass e: collection.getInitialList())
		{
		
			if(newRectangle.getStartX()<=e.getStartX()&&newRectangle.getStartY()>=e.getStartY()
			&&newRectangle.getEndX()>=e.getEndX() && newRectangle.getEndY()<=e.getEndY())
			{
				
				collection.addShapeSelected(e);
				
				
							}
			
		}
		//collection.getCanvas().repaint();
	}
}
	


