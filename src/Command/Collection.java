package Command;

import java.io.*;
import model.ShapeShadingType;
import model.shapes.ShapeClass;
import view.gui.PaintCanvas;
import java.util.*;
//reacts to the changes happening to modify the list;
//how to make shapes immutable. 
//making this the listener to update paint canvas; 	
//write into if else for appstate colors;
//this is my listener that updates PaintCanvas the observer;
public class Collection {
	 List<ShapeClass> initialList;
	List<ShapeClass> selectedList;
	List<ShapeClass> movedList;
	List<ShapeClass> copiedList;
	PaintCanvas paintCanvas;
	ShapeShadingType shade;
	private Listener listener;
//making this the listener to update paint canvas; 	
	//maybe it takes listener, listener takes canvas. 
	public Collection(PaintCanvas paintCanvas, Listener listener)
	{
		this.paintCanvas = paintCanvas;
		initialList=new ArrayList<ShapeClass>();
		selectedList=new ArrayList<ShapeClass>();
		movedList=new ArrayList<ShapeClass>();
		copiedList=new ArrayList<ShapeClass>();
		this.listener = listener;
	}
	public PaintCanvas getCanvas()
	{
		return paintCanvas;
	}
	//notify listener;
	public void notify(ShapeClass shape)
	{
		listener.makeShapeAppear(shape);
	}
	public void addInitial(ShapeClass shape)
	{
		initialList.add((ShapeClass) shape);
	}
	public void addMove(ShapeClass shape)
	{
		movedList.add((ShapeClass) shape);
		}
	public void deleteInitialList(ShapeClass shape)
	{
		
		initialList.remove(shape);
	
		listener.clearScreen();
	}
	public void deleteselectedList()
	{
		
		selectedList.clear();
	
		listener.clearScreen();
	}
	public void Clear(){
		listener.clearScreen();}
	
	public void deleteMove(ShapeClass shape)
	{
		movedList.remove(shape);
		}
		
	
	public void addShapeSelected(ShapeClass shape)
	{
		
		selectedList.add((ShapeClass) shape);
		
	}
	 
	public ArrayList<ShapeClass> getInitialList()
	{
		return (ArrayList<ShapeClass>)initialList;
	}
	
	public ArrayList<ShapeClass> getSelectedList()
	{
		return (ArrayList<ShapeClass>)selectedList;
	}
	public ArrayList<ShapeClass> getMovedList()
	{
		return (ArrayList<ShapeClass>)movedList;
	}
	public ArrayList<ShapeClass> getCopiedList()
	{
		return (ArrayList<ShapeClass>)copiedList;
	}




	}
	
	
