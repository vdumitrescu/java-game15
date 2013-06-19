package com.bebelici.game15;

public class Position {

	private final int row;
	private final int col;
	Position(int row, int col) {
		this.row = row;
		this.col = col;
	}
	
	public Position next(Move move) {
		switch (move) {
			case NORTH:
				return row > 0? new Position(row-1, col) : null; 
			case SOUTH:
				return row < Board.SIZE - 1? new Position(row+1, col) : null; 
			case WEST:
				return col > 0? new Position(row, col-1) : null; 
			case EAST:
				return col < Board.SIZE - 1? new Position(row, col+1) : null; 
		}
		return null;
	}
	
	@Override
	public String toString() {
		return "(" + row + ", " + col + ")";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		
		Position other = (Position) obj;
		return col == other.col && row == other.row;
	}

	public int row() {
		return row;
	}
	public int col() {
		return col;
	}
}
