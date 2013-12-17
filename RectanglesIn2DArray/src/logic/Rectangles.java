package logic;

public class Rectangles {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] array = { { 1, 2, -1, -4, 20 }, { -8, -3, 4, 2, 1 },
				{ 3, 8, 10, 1, 3 }, { -4, -1, 1, 7, 6 } };
		new Rectangles().getRectangles(array);
	}

	public void getRectangles(int[][] array) {
		int rectangles = 0;
		for (int rows = 1; rows <= array.length; rows++) {
			for (int columns = 1; columns <= array[0].length; columns++) {
				// print all rectangles of breadth = rows and length = columns.
				int ab = 0;
				int cd = ab + rows - 1;
				for (; cd < array.length; ab++, cd++) {
					int ad = 0;
					int bc = ad + columns - 1;
					for (; bc < array[0].length; ad++, bc++) {
						System.out.println("Rows: " + ab + " to " + cd + "\n"
								+ "Columns: " + ad + " to " + bc);
						print(array, ad, bc, ab, cd);
						rectangles++;
					}
				}
			}
		}
		//The number of rectangles can be caluculated by (row + 1)C2 * (column + 1)C2
		System.out.println("Rectangles: " + rectangles);
	}

	private void print(int[][] array, int left, int right, int bottom, int top) {
		// left and right mark the column boundaries. top and bottom marks the
		// row boundaries.
		for (int i = bottom; i <= top; i++) {
			for (int j = left; j <= right; j++) {
				System.out.print(array[i][j]);
				if(j + 1 <= right)
					System.out.print(", ");
			}
			System.out.println();
		}
		System.out.println("-------------------------------------------------");
	}

}
