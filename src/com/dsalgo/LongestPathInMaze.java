/*
For problem and solution description please visit the link below
http://www.dsalgo.com/2013/02/find-longest-path-in-maze.html
*/

package com.dsalgo;
import java.util.ArrayList;
import java.util.List;

public class LongestPathInMaze
{
	public static void main(String[] args)
	{
		boolean[][] maze = new boolean[10][10];
		makeRandomMaze(maze);
		printMaze(maze);
		List<Cell> path = findLongestPath(maze);
		if (path == null)
		{
			System.out.println("No path possible");
			return;
		}
		for (Cell cell : path)
			System.out.print(cell + ",");
		System.out.println();
	}

	private static List<Cell> findLongestPath(boolean[][] maze)
	{
		Cell start = new Cell(0, 0);
		Cell end = new Cell(maze.length - 1, maze[0].length - 1);
		List<Cell> path = findLongestPath(maze, start, end);
		return path;
	}

	private static List<Cell> findLongestPath(boolean[][] maze, Cell start,
			Cell end)
	{
		List<Cell> result = null;
		int rows = maze.length;
		int cols = maze[0].length;
		if (start.row < 0 || start.col < 0)
			return null;
		if (start.row == rows || start.col == cols)
			return null;
		if (maze[start.row][start.col] == true)
			return null;
		if (start.equals(end))
		{
			List<Cell> path = new ArrayList<Cell>();
			path.add(start);
			return path;
		}
		maze[start.row][start.col] = true;
		Cell[] nextCells = new Cell[4];
		nextCells[0] = new Cell(start.row + 1, start.col);
		nextCells[2] = new Cell(start.row, start.col + 1);
		nextCells[1] = new Cell(start.row - 1, start.col);
		nextCells[3] = new Cell(start.row, start.col - 1);
		int maxLength = -1;
		for (Cell nextCell : nextCells)
		{
			List<Cell> path = findLongestPath(maze, nextCell, end);
			if (path != null && path.size() > maxLength)
			{
				maxLength = path.size();
				path.add(0, start);
				result = path;
			}
		}
		maze[start.row][start.col] = false;
		if (result == null || result.size() == 0)
			return null;
		return result;
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
