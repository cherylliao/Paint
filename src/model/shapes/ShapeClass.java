package model.shapes;
import java.awt.Point;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.Graphics2D;
import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import model.colors.ColorAdapter;

import java.awt.BasicStroke;
import java.awt.Color;
public class ShapeClass {
	Point start;
	Point end;
	ShapeColor Pcolor;
	ShapeColor Scolor;
	ShapeShadingType shade;
	private ShapeType shapetype;   
      
	//boolean shaded type?
	public ShapeClass(Point start, Point end, ShapeType shapetype,
	ShapeColor Pcolor, ShapeColor Scolor,ShapeShadingType shade)
	{
		this.start=start;
		this.end=end;
		this.shapetype=shapetype;
		this.Pcolor=Pcolor;
		this.Scolor=Scolor;
		this.shade=shade;
	}
	public ShapeType getShape()
	{
		return shapetype;
	}
	public int getStartX()
	{
		return (int)start.getX();
	}
	public int getStartY()
	{
		return (int)start.getY();
	}
	public int getEndX()
	{
		return (int)end.getX();
	}
	public int getEndY()
	{
		return (int)end.getY();
	}
	public int getWidth()
	{
		return (int) (end.getX()-start.getX());
	}
	public int getHeight()
	{
		return (int) (start.getY()-end.getY());
	}
	public int[] getXPoints()
	{
		int[] A ={getStartX(), getStartX()+(getWidth()/2), getEndX()-(getWidth()/2)};
		return A;
	}
	public int[] getYPoints()
	{
		int[] A ={getStartY(), getStartY()+getHeight(), getEndY()-getHeight()};
		return A;
	}
	
	
	public ShapeColor getPColor() {
		// TODO Auto-generated method stub
		
		return Pcolor;
	}
	
	public ShapeColor getSColor() {
		// TODO Auto-generated method stub
		return Scolor;
	}
	public ShapeShadingType getShading(){
		return shade;
	}

	}
	
	

