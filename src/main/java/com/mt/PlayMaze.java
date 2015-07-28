package com.mt;

import com.mt.domain.Explorer;
import com.mt.domain.Maze;

/**
 * Play Maze class implementing two user stories.
 *
 */
public class PlayMaze 
{
    public static void main( String[] args )
    {
        //User Story -1 (Read the maze from the file)
        Maze maze = MazeManager.getInstance().readMaze("resources/Maze1.txt");        
        
        //User Story -2 (Make the explorer traverse through the maze)
        Explorer rob = new Explorer();
        MazeManager.getInstance().exploreMaze(rob, maze);
        
        //Print the path Rob travelled
       System.out.println(rob.getPathPositions()); 
       
    }
      
}
