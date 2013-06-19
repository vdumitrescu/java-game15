package com.bebelici.game15;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Game {

	public void playGame() {
		Board start = Board.randomBoard();
		System.out.println(start);
		List<Move> sol = solve(start);
		if (sol != null) {
			for (Move move : sol) {
				start = start.nextBoard(move);
				System.out.println(move + " ->\n" + start);
			}
		} else {
			System.out.println("No solution.");
		}
	}
	
	public List<Move> solve(Board initialBoard) {
		Deque<Board> toAnalyze = new LinkedList<Board>();
		toAnalyze.push(initialBoard);
		Set<Board> alreadyAnalyzed = new HashSet<Board>();
		
		while (!toAnalyze.isEmpty()) {
			Board board = toAnalyze.poll();
			if (board.isSolution()) {
				return board.moves();
			}
			
			for (Board next : board.next()) {
				if (!alreadyAnalyzed.contains(next)) {
					toAnalyze.addLast(next);
				}
			}
			alreadyAnalyzed.add(board);
		}
		
		return null;
	}
}
