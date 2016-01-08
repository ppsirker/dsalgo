package com.dsalgo;
import java.util.ArrayList;
import java.util.List;

public class FrogJump {

	public static void main(String[] args) {
		boolean[] stone = { true, false, true, true, true, false, true, false,
				true, false, true, true, false, true };
		System.out.println("Frog jump " + frogJump(stone));
	}

	static List<Integer> frogJump(boolean[] stone) {
		int[][] jumpTable = new int[stone.length + 1][stone.length + 1];
		if (frogJump(stone, 1, 0, jumpTable)) {
			List<Integer> result = new ArrayList<Integer>();
			int currentStone = 0;
			int jump = 1;
			while (currentStone < stone.length) {
				result.add(currentStone);
				jump = jumpTable[currentStone][jump];
				currentStone += jump;
			}
			result.add(stone.length);
			return result;
		}
		return null;
	}

	static boolean frogJump(boolean[] stone, int jump, int currentLocation,
			int[][] jumpTable) {
		if (currentLocation >= stone.length
				|| jumpTable[currentLocation][jump] != 0)
			return true;
		if (jump < 1 || !stone[currentLocation])
			return false;
		for (int i = 1; i > -2; --i) {
			if (frogJump(stone, jump + i, currentLocation + jump + i, jumpTable)) {
				jumpTable[currentLocation][jump] = jump + i;
				return true;
			}
		}
		return false;
	}
}
