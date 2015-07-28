package com.mt;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import com.mt.domain.Explorer;
import com.mt.domain.Fill;
import com.mt.domain.Maze;
import com.mt.domain.Position;
import com.mt.exceptions.CantMoveException;

/**
 * This class manages the maze. It can explore the maze and also read the maze
 * from the given file
 * 
 * @author kiran
 *
 */
public class MazeManager {
	private static MazeManager mazeManager = null;

	/**
	 * Method to return the instance of the MazeManager
	 * 
	 * @return MazeManager
	 */
	public static MazeManager getInstance() {
		if (mazeManager == null) {
			mazeManager = new MazeManager();
		}
		return mazeManager;
	}

	/**
	 * Method to read the maze from the given file
	 * 
	 * @param fileName
	 * @return
	 */
	public Maze readMaze(String fileName) {

		Maze maze = new Maze();
		int rows = 0;
		int columns = 0;
		Stream<String> lines = null;

		try {
			lines = Files.lines(Paths.get(fileName));

			List<char[]> lineList = new ArrayList<char[]>();

			lines.forEach(line -> {
				lineList.add(line.toCharArray());
			});

			Position[][] positions = new Position[lineList.get(0).length][lineList
					.size()];

			for (char[] cs : lineList) {
				columns = 0;
				for (char c : cs) {
					System.out.print(c);
					Position position = new Position(columns, rows);
					position.setFill(Fill.getFill(c));
					positions[columns][rows] = position;

					if (c == Fill.Start.getDisplayChar()) {
						maze.setStart(position);
					} else if (c == Fill.Exit.getDisplayChar()) {
						maze.setExit(position);
					}
					columns++;
				}

				rows++;
			}

			maze.setPositions(positions);
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {

			if (lines != null)
				lines.close();
		}

		return maze;
	}

	/**
	 * Method to explore the maze
	 * 
	 * @param explorer
	 * @param maze
	 */
	public void exploreMaze(Explorer explorer, Maze maze) {

		// Set the starting position
		explorer.changePosition(maze.getStart());
		Position nextPosition = explorer.getPosition();

		try {
			// Move around the maze
			while (true) {
				nextPosition = maze.moveNext(explorer.getPosition());
				System.out.println(nextPosition);
				explorer.changePosition(nextPosition);
				if (nextPosition.getFill() == Fill.Exit) {
					System.out.println("Reached to Exit");
					break;
				}

			}
		} catch (CantMoveException e) {
			System.out.println("At position X,Y:" + (nextPosition.getX() + 1)
					+ "," + (nextPosition.getY() + 1));
		}
	}
}
