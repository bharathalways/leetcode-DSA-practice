class Solution {
    int m, n;
    int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

    public boolean containsCycle(char[][] grid) {
        m = grid.length;
        n = grid[0].length;

        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    if (dfs(grid, visited, i, j, -1, -1)) return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] grid, boolean[][] visited, int x, int y, int px, int py) {
        visited[x][y] = true;

        for (int[] d : dir) {
            int nx = x + d[0];
            int ny = y + d[1];

            if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
            if (grid[nx][ny] != grid[x][y]) continue;

            if (!visited[nx][ny]) {
                if (dfs(grid, visited, nx, ny, x, y)) return true;
            } else if (nx != px || ny != py) {
                return true;
            }
        }
        return false;
    }
}