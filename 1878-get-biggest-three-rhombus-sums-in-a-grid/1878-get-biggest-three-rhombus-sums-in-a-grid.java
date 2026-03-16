import java.util.*;

class Solution {
    public int[] getBiggestThree(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        TreeSet<Integer> set = new TreeSet<>();

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {

                set.add(grid[r][c]);

                for (int k = 1; r + 2 * k < m && c - k >= 0 && c + k < n; k++) {

                    int sum = 0;

                    int x = r;
                    int y = c;

                    for (int i = 0; i < k; i++)
                        sum += grid[x + i][y + i];

                    for (int i = 0; i < k; i++)
                        sum += grid[x + k + i][y + k - i];

                    for (int i = 0; i < k; i++)
                        sum += grid[x + 2 * k - i][y - i];

                    for (int i = 0; i < k; i++)
                        sum += grid[x + k - i][y - k + i];

                    set.add(sum);
                }
            }
        }

        int size = Math.min(3, set.size());
        int[] result = new int[size];

        for (int i = 0; i < size; i++) {
            result[i] = set.pollLast();
        }

        return result;
    }
}