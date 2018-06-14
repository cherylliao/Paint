package view.gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Ellipse2D;

import model.ShapeColor;
import model.ShapeShadingType;
import model.StartAndEndPointMode;
import model.colors.ColorAdapter;
import model.shapes.ShapeClass;

public class Display {
	StartAndEndPointMode DRAW;
	StartAndEndPointMode SELECT;
	ShapeClass shape;
	Graphics2D graphics;

	ShapeColor paint;
	PaintCanvas canvas;
	ShapeShadingType OUTLINE,FILLED_IN,OUTLINE_AND_FILLED_IN;
	Stroke stroke = new BasicStroke(2f);

	
	public Display(PaintCanvas canvas)
	{
		this.canvas=canvas;
		graphics=canvas.getGraphics2D();
	
	}
   public void ClearRectangle()
   {
	   graphics.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
   }
   public void ShapeAppear(ShapeClass shape)
   {
	   
	   switch(shape.getShape())
		   {
		   case RECTANGLE: 
			   switch(shape.getShading())
			   {
			   case OUTLINE:
				   outline(shape);
				   graphics.drawRect(shape.getStartX(), shape.getStartY(), shape.getWidth(), shape.getHeight());	   
				   break;
			   case OUTLINE_AND_FILLED_IN:
			   graphics.setPaint(showSColor(shape));  
			   graphics.fillRect(shape.getStartX(), shape.getStartY(), shape.getWidth(), shape.getHeight());
			   outline(shape);
			   graphics.drawRect(shape.getStartX(), shape.getStartY(), shape.getWidth(), shape.getHeight());
		   break;
			   case FILLED_IN:
				   graphics.setPaint(showSColor(shape));  
				   graphics.fillRect(shape.getStartX(), shape.getStartY(), shape.getWidth(), shape.getHeight());
				   break;}
			   break;
		 case TRIANGLE: 
			 switch(shape.getShading())
			 {
			 case OUTLINE:
				 outline(shape);
				   graphics.drawPolygon(shape.getXPoints(), shape.getYPoints(), 3);
				   break;
			 case OUTLINE_AND_FILLED_IN:
			   graphics.setPaint(showSColor(shape));  
		   graphics.fillPolygon(shape.getXPoints(), shape.getYPoints(), 3);
		   outline(shape);
		   graphics.drawPolygon(shape.getXPoints(), shape.getYPoints(), 3);
		   break;
			 case FILLED_IN:
				 graphics.setPaint(showSColor(shape));  
				   graphics.fillPolygon(shape.getXPoints(), shape.getYPoints(), 3);
		   break;}
	       break;
		   case ELLIPSE: 
			   switch(shape.getShading()) {
			   case OUTLINE_AND_FILLED_IN:
			   graphics.setPaint(showSColor(shape));  
		   graphics.fill(new Ellipse2D.Double(shape.getStartX(), shape.getStartY(), shape.getWidth(), shape.getHeight()));
		   outline(shape);
		   graphics.draw(new Ellipse2D.Double(shape.getStartX(), shape.getStartY(), shape.getWidth(), shape.getHeight()));
		   break;
			   case OUTLINE:
				   outline(shape);
				   graphics.draw(new Ellipse2D.Double(shape.getStartX(), shape.getStartY(), shape.getWidth(), shape.getHeight()));
				   break;
			   case FILLED_IN:
				   graphics.setPaint(showSColor(shape));  
				   graphics.fill(new Ellipse2D.Double(shape.getStartX(), shape.getStartY(), shape.getWidth(), shape.getHeight()));
				   break;}
				   break;
				  
   }
	   
   }
   
		
	
   public Color showPColor(ShapeClass shape)
   {
	   
	   return ColorAdapter.colormethod(shape.getPColor());
       
	   
   }
   public Color showSColor(ShapeClass shape)
   {
	   
       return ColorAdapter.colormethod(shape.getSColor());
   }
   
	public void outline(ShapeClass shape)
	{
		graphics.setColor(showPColor(shape));
		graphics.setStroke(stroke);
		
	}
	


}
