package com.bebelici.game15;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public enum Move {
	NORTH, EAST, SOUTH, WEST;

	public static List<Move> ALL = Arrays.asList(NORTH, EAST, SOUTH, WEST);

	public static Move randomMove() {
		return ALL.get(new Random().nextInt(255) % ALL.size());
	}

}
