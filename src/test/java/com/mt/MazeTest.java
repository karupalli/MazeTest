package com.mt;

import static org.junit.Assert.*;

import org.junit.Test;

import com.mt.domain.Explorer;
import com.mt.domain.Fill;
import com.mt.domain.Maze;
import com.mt.domain.Position;

public class MazeTest {

	@Test
	 public void testFourPositions()
    {
    	Position[][] positions = new Position[2][2];
    	positions[0][0] = new Position(0,0);
    	positions[0][1] = new Position(0,1);
    	positions[1][0] = new Position(1,0);
    	positions[1][1] = new Position(1,1);
    	
    	positions[0][0].setFill(Fill.Start);
    	positions[0][1].setFill(Fill.Exit);
    	positions[1][0].setFill(Fill.Wall);
    	positions[1][1].setFill(Fill.Wall);
    	
    	Maze maze = new Maze();
    	maze.setStart(positions[0][0]);
    	maze.setPositions(positions);
    
    	 Explorer rob = new Explorer();
         MazeManager.getInstance().exploreMaze(rob, maze);
    	
    	
    	assertEquals(1, rob.getPosition().getY());
    	assertEquals(0, rob.getPosition().getX());
    }
	
	 public void testNinePositions()
	    {
	    	Position[][] positions = new Position[3][3];
	    	positions[0][0] = new Position(0,0);
	    	positions[0][1] = new Position(0,1);
	    	positions[0][2] = new Position(0,2);
	    	
	    	positions[1][0] = new Position(1,0);
	    	positions[1][1] = new Position(1,1);
	    	positions[1][2] = new Position(1,2);
	    	
	    	positions[2][0] = new Position(2,0);
	    	positions[2][1] = new Position(2,1);
	    	positions[2][2] = new Position(2,2);
	    	
	    	positions[0][0].setFill(Fill.Start);
	    	positions[0][1].setFill(Fill.Wall);
	    	positions[0][2].setFill(Fill.Space);
	    	
	    	
	    	positions[1][0].setFill(Fill.Wall);
	    	positions[1][1].setFill(Fill.Wall);
	    	positions[1][2].setFill(Fill.Space);
	    	
	    	positions[2][0].setFill(Fill.Wall);
	    	positions[2][1].setFill(Fill.Wall);
	    	positions[2][2].setFill(Fill.Exit);
	    
	    	
	    	Maze maze = new Maze();
	    	maze.setStart(positions[0][0]);
	    	maze.setPositions(positions);
	    
	    	 Explorer rob = new Explorer();
	         MazeManager.getInstance().exploreMaze(rob, maze);
	    	
	    	
	    	assertEquals(2, rob.getPosition().getY());
	    	assertEquals(2, rob.getPosition().getX());
	    }
}
