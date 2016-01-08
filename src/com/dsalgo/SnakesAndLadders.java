/*
For problem and solution description please visit the link below
http://www.dsalgo.com/2013/02/SnakesAndLadders.php.html
*/

package com.dsalgo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class SnakesAndLadders
{

 private static List<Movers> snakesAndLadders;

 public static void main(String[] args)
 {

  snakesAndLadders = new ArrayList<Movers>();

  snakesAndLadders.add(new Movers(9, 31));

  snakesAndLadders.add(new Movers(17, 7));

  snakesAndLadders.add(new Movers(28, 84));
  
  snakesAndLadders.add(new Movers(85, 41));

  snakesAndLadders.add(new Movers(51, 67));

  snakesAndLadders.add(new Movers(54, 34));

  snakesAndLadders.add(new Movers(62, 19));

  snakesAndLadders.add(new Movers(64, 60));

  snakesAndLadders.add(new Movers(71, 91));

  snakesAndLadders.add(new Movers(80, 99));

  snakesAndLadders.add(new Movers(87, 24));

  snakesAndLadders.add(new Movers(93, 73));


  int[] moveMap = new int[101];

  for (Movers movers : snakesAndLadders)
   moveMap[movers.start] = movers.end;

  int[] minMove = new int[101];
  int[] dice = new int[101];
  int[]fromCell=new int[101];
  
  LinkedList<Integer> queue = new LinkedList<Integer>();
  queue.add(1);
  boolean finished=false;
  while (!queue.isEmpty()&&!finished)
  {
   int cell = queue.poll();
   for (int i = 1; i <= 6; ++i)
   {
    int newCell = moveMap[cell + i] == 0 ? cell + i : moveMap[cell + i];
    if (minMove[newCell] == 0)
    {
     minMove[newCell] = minMove[cell] + 1;
     dice[newCell]=i;
     fromCell[newCell]=cell;
     queue.add(newCell);
    }
    if(newCell==100)
    {
     finished=true;
     break;
    }

   }

  }
  int cell=100;
  Stack<String> stack=new Stack<String>();
  while(cell!=1)
  {
   stack.push("new cell "+cell);
   stack.push("dice throw "+dice[cell]);
   
   cell=fromCell[cell];
  }
  while(!stack.isEmpty())
   System.out.println(stack.pop());
 }
}

/**
 * Snakes and Ladders basically do the same thing. They move the coin from one
 * place to another if they move in positive direction we call them ladders
 * otherwise snakes.
 * 
 */
class Movers
{

 public int start;

 public int end;

 public boolean goingUp;

 public Movers(int start, int end)
 {

  this.start = start;

  this.end = end;
 }
}      
