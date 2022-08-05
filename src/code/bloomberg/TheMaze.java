package code.bloomberg;

//https://leetcode.com/problems/the-maze/
public class TheMaze {

    int[][] steps = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        //DFS + cache
        int rows = maze.length;
        int cols = maze[0].length;
        boolean[][] visited = new boolean[rows][cols];

        return dfs(maze, start, destination, visited, rows, cols);
    }

    private boolean dfs(int[][] maze, int[] start, int[] des, boolean[][] visited, int rows, int cols) {
        if (visited[start[0]][start[1]]) {
            return false;
        }
        if (start[0] == des[0] && start[1] == des[1]) {
            return true;
        }

        visited[start[0]][start[1]] = true;
        for (int[] step : steps) {
            int dx = start[0];
            int dy = start[1];
            while (dx + step[0] >= 0 && dx + step[0] < rows && dy + step[1] >= 0 && dy + step[1] < cols && maze[dx + step[0]][dy + step[1]] != 1) {
                dx += step[0];
                dy += step[1];
            }
            if (dfs(maze, new int[]{dx, dy}, des, visited, rows, cols)) {
                return true;
            }
        }
        return false;
    }
}
