package model.colors;

import java.awt.Color;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

import model.ShapeColor;


public class ColorAdapter{
	
	
	static ShapeColor BLACK,BLUE,CYAN,DARK_GRAY,GRAY,GREEN,
    LIGHT_GRAY, MAGENTA, ORANGE, PINK, RED, WHITE, YELLOW;
	
	//pass into the color num?
	public static Color colormethod(ShapeColor color){
	switch(color.toString())
		{
		case"BLUE": return Color.BLUE;
		case"RED": return Color.RED;
		case"BLACK": return Color.BLACK;
		case"CYAN": return Color.CYAN;
		case"DARK_GRAY": return Color.DARK_GRAY;
		case"GRAY": return Color.GRAY;
		case"GREEN": return Color.GREEN;
		case"LIGHT_GRAY": return Color.LIGHT_GRAY;
		case"MAGENTA": return Color.MAGENTA;
		case"ORANGE": return Color.ORANGE;
		case"PINK": return Color.PINK;
		case"WHITE": return Color.WHITE;
		case"YELLOW": return Color.YELLOW;
	}
	return null;
	

}
	}
