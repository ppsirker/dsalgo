/*
For problem and solution description please visit the link below
http://www.dsalgo.com/2013/02/towers-of-hanoi.html
*/

package com.dsalgo;
import java.util.Stack;


public class TowersOfHanoi
{
	public static void main(String[] args)
	{
		Tower towerSource = new Tower("1");
		Tower towerDestination = new Tower("2");
		Tower towerHelper = new Tower("3");
		towerSource.stack.push(4);
		towerSource.stack.push(3);
		towerSource.stack.push(2);
		towerSource.stack.push(1);
		move(towerSource.stack.size(), towerSource, towerDestination,
				towerHelper);
	}

	private static void move(int size, Tower towerSource,
			Tower towerDestination, Tower towerHelper)
	{
		if (towerSource.stack.isEmpty())
			return;
		if (size == 1)
		{
			System.out.println("Move " + towerSource.stack.peek()
					+ " from tower " + towerSource.name + " to tower "
					+ towerDestination.name);
			towerDestination.stack.push(towerSource.stack.pop());
			return;
		}
		move(size - 1, towerSource, towerHelper, towerDestination);
		move(1, towerSource, towerDestination, towerHelper);
		move(size - 1, towerHelper, towerDestination, towerSource);
	}

	private static class Tower
	{
		public String name;
		public Stack<Integer> stack = new Stack<Integer>();

		public Tower(String name)
		{
			this.name = name;
		}
	}
}
