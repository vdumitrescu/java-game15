package com.bebelici.game15;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

public class BoardTest {

	@Test
	public void testCorner() {
		Board testBoard = new Board(new int[][]{ { 1, 2, 3 }, {4, 5, 6}, {7, 8, 0} });
		List<Board> next = testBoard.next();
		
		check(next,
			new Board(new int[][]{ { 1, 2, 3 }, {4, 5, 6}, {7, 0, 8} }),
			new Board(new int[][]{ { 1, 2, 3 }, {4, 5, 0}, {7, 8, 6} }));
	}

	@Test
	public void testSide() {
		Board testBoard = new Board(new int[][]{ { 1, 2, 3 }, {4, 5, 6}, {7, 0, 8} });
		List<Board> next = testBoard.next();
		
		check(next,
			new Board(new int[][]{ { 1, 2, 3 }, {4, 5, 6}, {7, 8, 0} }),
			new Board(new int[][]{ { 1, 2, 3 }, {4, 5, 6}, {0, 7, 8} }),
			new Board(new int[][]{ { 1, 2, 3 }, {4, 0, 6}, {7, 5, 8} }));
	}

	@Test
	public void testMiddle() {
		Board testBoard = new Board(new int[][]{ { 1, 2, 3 }, {4, 0, 6}, {7, 5, 8} });
		List<Board> next = testBoard.next();
		
		check(next,
			new Board(new int[][]{ { 1, 0, 3 }, {4, 2, 6}, {7, 5, 8} }),
			new Board(new int[][]{ { 1, 2, 3 }, {4, 5, 6}, {7, 0, 8} }),
			new Board(new int[][]{ { 1, 2, 3 }, {0, 4, 6}, {7, 5, 8} }),
			new Board(new int[][]{ { 1, 2, 3 }, {4, 6, 0}, {7, 5, 8} }));
	}
	
	private void check(List<Board> actual, Board... expected) {
		assertEquals(expected.length, actual.size());
		for (Board expectedBoard : expected) {
			assertTrue("Expected to find " + expectedBoard + " but not there", actual.contains(expectedBoard));
		}
	}

}
