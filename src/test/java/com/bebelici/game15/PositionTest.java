package com.bebelici.game15;

import static org.junit.Assert.*;

import org.junit.Test;

public class PositionTest {

	@Test
	public void testNorth() {
		assertNull(new Position(0, 0).next(Move.NORTH));
		assertEquals(new Position(2, 1), new Position(3, 1).next(Move.NORTH));
	}

	@Test
	public void testSouth() {
		assertNull(new Position(Board.SIZE - 1, 1).next(Move.SOUTH));
		assertEquals(new Position(1, 1), new Position(0, 1).next(Move.SOUTH));
	}

	@Test
	public void testEast() {
		assertNull(new Position(0, Board.SIZE - 1).next(Move.EAST));
		assertEquals(new Position(2, 1), new Position(2, 0).next(Move.EAST));
	}

	@Test
	public void testWest() {
		assertNull(new Position(0, 0).next(Move.WEST));
		assertEquals(new Position(1, 0), new Position(1, 1).next(Move.WEST));
	}

}
