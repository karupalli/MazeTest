package com.mt.domain;

/**
 * Represents the position in the maze
 * @author kiran
 *
 */
public class Position {

	private int x;
	private int y;
	private Fill fill;
	
	public Position(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public Fill getFill() {
		return fill;
	}
	public void setFill(Fill fill) {
		this.fill = fill;
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public String toString()
	{
		return x+","+y;
	}
	
}
