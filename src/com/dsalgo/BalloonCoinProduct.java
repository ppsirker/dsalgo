package com.dsalgo;

public class BalloonCoinProduct {

	public static void main(String[] args) {
		int[] coins = { 1, 3, 4, 5, 4, 5, 3, 6, 7 };
		int maxProduct = getMaxCoins(coins);
		System.out.println("Max product: " + maxProduct);
	}

	public static int getMaxCoins(int[] coins) {
		int n = coins.length;
		Integer[][] memo = new Integer[n][n];
		return getMaxCoins(coins, 0, n - 1, memo);
	}

	public static int getMaxCoins(int[] coins, int start, int end,
			Integer[][] memo) {
		if (start == end){
			memo[start][end]=coins[start];
			return coins[start];
		}
		if(start>end)
			return 0;
		if (memo[start][end] == null) {
			int max=0;
			for (int i = start + 1; i < end - 1; ++i) {
				max = Math.max(max,
						getMaxCoins(coins, start + 1, i - 1, memo)
								+ coins[start] * coins[i] * coins[end]
								+ getMaxCoins(coins, i + 1, end - 1, memo));
			}
			memo[start][end]=max;
		}
		return memo[start][end];
	}
}
