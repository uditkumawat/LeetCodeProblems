package code.microsoft;

/**
 * https://leetcode.com/problems/island-perimeter/
 *
 * You are given row x col grid representing a map where grid[i][j] = 1 represents land and grid[i][j] = 0 represents water.
 *
 * Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).
 *
 * The island doesn't have "lakes", meaning the water inside isn't connected to the water around the island. One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.
 */
//TC - O(m*n)
public class IslandPerimeter {

    public int islandPerimeter(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        int up, down, left, right;
        int result = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    if (r == 0) { up = 0; }
                    else { up = grid[r-1][c]; }

                    if (c == 0) { left = 0; }
                    else { left = grid[r][c-1]; }

                    if (r == rows-1) { down = 0; }
                    else { down = grid[r+1][c]; }

                    if (c == cols-1) { right = 0; }
                    else { right = grid[r][c+1]; }

                    result += 4-(up+left+right+down);
                }
            }
        }

        return result;
    }
}
