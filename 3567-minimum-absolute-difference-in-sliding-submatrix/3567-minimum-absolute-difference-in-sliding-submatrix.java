import java.util.*;

class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int[][] ans = new int[m - k + 1][n - k + 1];

        for (int i = 0; i <= m - k; i++) {
            for (int j = 0; j <= n - k; j++) {

                int size = k * k;
                int[] arr = new int[size];
                int idx = 0;

                for (int x = i; x < i + k; x++) {
                    for (int y = j; y < j + k; y++) {
                        arr[idx++] = grid[x][y];
                    }
                }

                Arrays.sort(arr);

                int min = Integer.MAX_VALUE;

                for (int t = 1; t < size; t++) {
                    if (arr[t] != arr[t - 1]) {
                        min = Math.min(min, arr[t] - arr[t - 1]);
                    }
                }

                if (min == Integer.MAX_VALUE) min = 0;

                ans[i][j] = min;
            }
        }

        return ans;
    }
}