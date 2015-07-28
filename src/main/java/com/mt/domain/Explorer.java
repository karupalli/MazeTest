package com.mt.domain;

import java.util.ArrayList;
import java.util.List;

public class Explorer {
	private String name;
	private Position position;
	private List<Position> pathPositions = new ArrayList<Position>();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Position getPosition() {
		return position;
	}
	public void changePosition(Position newPosition) {
		
		//Save the current position
		if(position!=null)
			pathPositions.add(position);
		
		this.position = newPosition;
	}
	
	
	public List<Position> getPathPositions()
	{
		return pathPositions;
	}
}
