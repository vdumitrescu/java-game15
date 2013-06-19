package com.bebelici.game15;

import java.util.ArrayList;
import java.util.List;

public class Board {

	public static final int SIZE = 3;
	
	private static final Board SOLUTION = createSolution();
	private final int[][] cells = new int[SIZE][SIZE];
	private final Position hole;
	private final List<Move> moves;
	
	public Board(int[][] cells) {
		this(cells, new ArrayList<Move>());
	}
	
	public Board(int[][] cells, List<Move> moves) {
		Position h = null;
		for (int i = 0; i < SIZE; ++i) {
			for (int j = 0; j < SIZE; ++j) {
				this.cells[i][j] = cells[i][j];
				if (cells[i][j] == 0) {
					h = new Position(i, j);
				}
			}
		}
		hole = h;
		this.moves = moves;
	}
	
	public List<Board> next() {
		List<Board> result = new ArrayList<Board>();
		for (Move move : Move.ALL) {
			Position next = hole.next(move);
			if (next != null) {
				result.add(nextBoard(move));
			}
		}
		return result;
	}
	
	public Board nextBoard(Move move) {
		List<Move> newMoves = new ArrayList<Move>();
		newMoves.addAll(moves);
		newMoves.add(move);
		
		int[][] newCells = new int[SIZE][SIZE];
		for (int i = 0; i < SIZE; ++i) {
			for (int j = 0; j < SIZE; ++j) {
				newCells[i][j] = cells[i][j];
			}
		}
		Position newHole = hole.next(move);
		if (newHole == null) return this;
		newCells[hole.row()][hole.col()] = cells[newHole.row()][newHole.col()];
		newCells[newHole.row()][newHole.col()] = 0;
		return new Board(newCells, newMoves);
	}

	@Override
	public String toString() {
		StringBuffer b = new StringBuffer();
		for (int i = 0; i < SIZE; ++i) {
			b.append("(");
			for (int j = 0; j < SIZE; ++j) {
				b.append(" " + cells[i][j]);
			}
			b.append(" )\n");
		}
		return b.toString();
	}
	
	public List<Move> moves() {
		return moves;
	}

	private static Board createSolution() {
		int[][] cells = new int[SIZE][SIZE];
		int c = 1;
		for (int i = 0; i < SIZE; ++i) {
			for (int j = 0; j < SIZE; ++j) {
				cells[i][j] = c++;
			}
		}
		cells[SIZE-1][SIZE-1] = 0;
		return new Board(cells, new ArrayList<Move>());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		for (int i = 0; i < SIZE; ++i) {
			for (int j = 0; j < SIZE; ++j) {
				result = prime * result + this.cells[i][j];
			}
		}
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Board other = (Board) obj;

		for (int i = 0; i < SIZE; ++i) {
			for (int j = 0; j < SIZE; ++j) {
				if (cells[i][j] != other.cells[i][j])
					return false;
			}
		}
		return true;
	}
	
	public static Board randomBoard() {
		Board board = SOLUTION;
		for (int i = 0; i < 250; i++) {
			board = board.nextBoard(Move.randomMove());
		}
		board.moves.clear();
		return board;
	}

	public boolean isSolution() {
		return equals(SOLUTION);
	}
	

}
