import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    bfs(grid, i, j, rows, cols);
                }
            }
        }

        return count;
    }

    void bfs(char[][] grid, int i, int j, int rows, int cols) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { i, j });
        grid[i][j] = '0'; // make as visited

        int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int[] dir : directions) {
                int newRow = curr[0] + dir[0];
                int newCol = curr[1] + dir[1];
                if (newRow >= 0 && newRow < rows
                        && newCol >= 0 && newCol < cols
                        && grid[newRow][newCol] == '1') {
                    grid[newRow][newCol] = '0';
                    queue.add(new int[] { newRow, newCol });
                }
            }
        }
    }
}