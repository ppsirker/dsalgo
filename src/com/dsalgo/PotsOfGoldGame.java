/*
For problem and solution description please visit the link below
http://www.dsalgo.com/2013/02/gold-coins-in-pots-game.html
*/

package com.dsalgo;


public class PotsOfGoldGame
{
 public static void main(String[] args)
 {
  int[] goldPots =
  { 12, 32, 4, 23, 6, 42, 16, 3, 85, 23, 4, 7, 3, 5, 45, 34, 2, 1 };
  int coins = getMaxGold(goldPots);
  System.out.println(coins);
 }

 private static int getMaxGold(int[] goldPots)
 {
  Integer[][]memo=new Integer[goldPots.length][goldPots.length];
  return getMaxGold(goldPots, 0, goldPots.length - 1,memo);
 }

 private static int getMaxGold(int[] goldPots, int startIndex, int endIndex,Integer[][]memo)
 {
  if (startIndex > endIndex)
   return 0;
  if(memo[startIndex][endIndex]!=null)
   return memo[startIndex][endIndex];
  int coinsIfStart = goldPots[startIndex]
    + Math.min(getMaxGold(goldPots, startIndex + 2, endIndex,memo),
      getMaxGold(goldPots, startIndex + 1, endIndex - 1,memo));
  int coinsIfEnd = goldPots[endIndex]
    + Math.min(getMaxGold(goldPots, startIndex, endIndex - 2,memo),
      getMaxGold(goldPots, startIndex + 1, endIndex - 1,memo));
  memo[startIndex][endIndex]=Math.max(coinsIfStart, coinsIfEnd);
  return memo[startIndex][endIndex];
 }
}
