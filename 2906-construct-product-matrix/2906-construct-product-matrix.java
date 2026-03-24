class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int size = n * m;
        int MOD = 12345;

        long[] arr = new long[size];
        
        int idx = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                arr[idx++] = grid[i][j] % MOD;
            }
        }

        long[] res = new long[size];

        long prefix = 1;
        for(int i = 0; i < size; i++){
            res[i] = prefix;
            prefix = (prefix * arr[i]) % MOD;
        }

        long suffix = 1;
        for(int i = size - 1; i >= 0; i--){
            res[i] = (res[i] * suffix) % MOD;
            suffix = (suffix * arr[i]) % MOD;
        }

        int[][] result = new int[n][m];
        idx = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                result[i][j] = (int)(res[idx++] % MOD);
            }
        }

        return result;
    }
}