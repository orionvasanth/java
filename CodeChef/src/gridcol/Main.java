package gridcol;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
	//http://www.codechef.com/problems/GRIDCOL

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the column: ");
		
		for (int loop = scanner.nextInt(); loop > 0; loop--) {
			int[][] grid = new int[3][scanner.nextInt()];
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < grid[i].length; j++) {
					grid[i][j] = scanner.nextInt();
				}
			}
			Arrays.fill(grid[2], Integer.MIN_VALUE);

			Main color = new Main();
			System.out.println(color.findCount(grid));
		}
		scanner.close();
	}

	private HashMap<Integer, Boolean> colors;
	int count;

	{
		colors = new HashMap<>();
		colors.put(1, Boolean.TRUE);
		colors.put(2, Boolean.TRUE);
		colors.put(3, Boolean.TRUE);
		colors.put(4, Boolean.TRUE);
	}

	public Long findCount(int[][] grid) {
		fill(grid, 0);
		return (count % 1000000007L);
	}

	private void fill(int[][] grid, int column) {
		for (int i = 1; i <= 4; i++) {
			if (colors.get(i))
				if (color(grid, column, i))
					if (column + 1 < grid[2].length)
						fill(grid, column + 1);
					else {
						if (column == grid[2].length - 1
								&& grid[2][column] != Integer.MIN_VALUE) {
							count++;
						}
					}
		}
		if (grid[2][column] != Integer.MIN_VALUE) {
			colors.put(grid[2][column], Boolean.TRUE);
			grid[2][column] = Integer.MIN_VALUE;
		}
	}

	private boolean color(int[][] grid, int column, int color) {
		if (grid[2][column] != Integer.MIN_VALUE) {
			colors.put(grid[2][column], Boolean.TRUE);
		}
		if (grid[0][column] != color && grid[1][column] != color) {
			grid[2][column] = color;
			colors.put(color, Boolean.FALSE);
			return true;
		} else {
			grid[2][column] = Integer.MIN_VALUE;
			return false;
		}
	}

}
