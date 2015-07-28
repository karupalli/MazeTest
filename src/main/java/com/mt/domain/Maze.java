package com.mt.domain;

import com.mt.exceptions.CantMoveException;

public class Maze {

	Position[][] positions;
	Position start;
	Position exit;

	public Position[][] getPositions() {
		return positions;
	}

	public void setPositions(Position[][] positions) {
		this.positions = positions;
	}

	public Position getStart() {
		return start;
	}

	public void setStart(Position start) {
		this.start = start;
	}

	public Position getExit() {
		return exit;
	}

	public void setExit(Position exit) {
		this.exit = exit;
	}

	/**
	 * Moves the position to next avaialable space
	 * 
	 * @param position
	 * @return
	 * @throws CantMoveException
	 */
	public Position moveNext(Position position) throws CantMoveException {
		Position returnPosition = null;
		position.setFill(Fill.Travelled);
		Position nextPosition;

		// check 4 sides if any position is space or exit
		if (position.getX() + 1 < positions.length) {
			nextPosition = positions[position.getX() + 1][position.getY()];
			if (nextPosition.getFill() == Fill.Space
					|| nextPosition.getFill() == Fill.Exit) {
				return nextPosition;

			}
		}

		if (position.getX() - 1 >= 0) {
			nextPosition = positions[position.getX() - 1][position.getY()];
			if (nextPosition.getFill() == Fill.Space
					|| nextPosition.getFill() == Fill.Exit) {

				return nextPosition;
			}
		}

		if (position.getY() + 1 < positions[0].length) {
			nextPosition = positions[position.getX()][position.getY() + 1];
			if (nextPosition.getFill() == Fill.Space
					|| nextPosition.getFill() == Fill.Exit) {

				return nextPosition;
			}
		}

		if (position.getY() - 1 >= 0) {
			nextPosition = positions[position.getX()][position.getY() - 1];
			if (nextPosition.getFill() == Fill.Space
					|| nextPosition.getFill() == Fill.Exit) {

				return nextPosition;
			}
		}

		if (returnPosition == null)
			throw new CantMoveException();

		return returnPosition;
	}
}
