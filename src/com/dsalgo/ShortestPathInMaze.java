/*
For problem and solution description please visit the link below
http://www.dsalgo.com/2013/02/find-shortest-path-in-maze.html
*/

package com.dsalgo;

import java.util.LinkedList;
import java.util.List;

public class ShortestPathInMaze
{
	public static void main(String[] args)
	{
		boolean[][] maze = new boolean[10][10];
		makeRandomMaze(maze);
		printMaze(maze);
		List<Cell> path = findShortestPath(maze);
		if (path == null)
		{
			System.out.println("No path possible");
			return;
		}
		for (Cell cell : path)
			System.out.print(cell + ",");
	}

	private static List<Cell> findShortestPath(boolean[][] maze)
	{
		int[][] levelMatrix = new int[maze.length][maze[0].length];
		for (int i = 0; i < maze.length; ++i)
			for (int j = 0; j < maze[0].length; ++j)
			{
				levelMatrix[i][j] = maze[i][j] == true ? -1 : 0;
			}
		LinkedList<Cell> queue = new LinkedList<Cell>();
		Cell start = new Cell(0, 0);
		Cell end = new Cell(maze.length - 1, maze[0].length - 1);
		queue.add(start);
		levelMatrix[start.row][start.col] = 1;
		while (!queue.isEmpty())
		{
			Cell cell = queue.poll();
			if (cell == end)
				break;
			int level = levelMatrix[cell.row][cell.col];
			Cell[] nextCells = new Cell[4];
			nextCells[3] = new Cell(cell.row, cell.col - 1);
			nextCells[2] = new Cell(cell.row - 1, cell.col);
			nextCells[1] = new Cell(cell.row, cell.col + 1);
			nextCells[0] = new Cell(cell.row + 1, cell.col);

			for (Cell nextCell : nextCells)
			{
				if (nextCell.row < 0 || nextCell.col < 0)
					continue;
				if (nextCell.row == maze.length
						|| nextCell.col == maze[0].length)
					continue;
				if (levelMatrix[nextCell.row][nextCell.col] == 0)
				{
					queue.add(nextCell);
					levelMatrix[nextCell.row][nextCell.col] = level + 1;
				}
			}
		}
		if (levelMatrix[end.row][end.col] == 0)
			return null;
		LinkedList<Cell> path = new LinkedList<Cell>();
		Cell cell = end;
		while (!cell.equals(start))
		{
			path.push(cell);
			int level = levelMatrix[cell.row][cell.col];
			Cell[] nextCells = new Cell[4];
			nextCells[0] = new Cell(cell.row + 1, cell.col);
			nextCells[1] = new Cell(cell.row, cell.col + 1);
			nextCells[2] = new Cell(cell.row - 1, cell.col);
			nextCells[3] = new Cell(cell.row, cell.col - 1);
			for (Cell nextCell : nextCells)
			{
				if (nextCell.row < 0 || nextCell.col < 0)
					continue;
				if (nextCell.row == maze.length
						|| nextCell.col == maze[0].length)
					continue;
				if (levelMatrix[nextCell.row][nextCell.col] == level - 1)
				{
					cell = nextCell;
					break;
				}
			}
		}
		return path;
	}

	private static class Cell
	{
		public int row;
		public int col;

		public Cell(int row, int column)
		{
			this.row = row;
			this.col = column;
		}

		@Override
		public boolean equals(Object obj)
		{
			if (this == obj)
				return true;
			if ((obj == null) || (obj.getClass() != this.getClass()))
				return false;
			Cell cell = (Cell) obj;
			if (row == cell.row && col == cell.col)
				return true;
			return false;
		}

		@Override
		public String toString()
		{
			return "(" + row + "," + col + ")";
		}
	}

	private static void printMaze(boolean[][] maze)
	{
		for (int i = 0; i < maze.length; ++i)
		{
			for (int j = 0; j < maze[i].length; ++j)
			{
				if (maze[i][j])
					System.out.print("#|");
				else
					System.out.print("_|");
			}
			System.out.println();
		}
	}

	private static void makeRandomMaze(boolean[][] maze)
	{
		for (int i = 0; i < maze.length; ++i)
		{
			for (int j = 0; j < maze[0].length; ++j)
			{
				maze[i][j] = (int) (Math.random() * 3) == 1;
			}
		}
		maze[0][0] = false;
		maze[maze.length - 1][maze[0].length - 1] = false;

	}
}
