class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
        int shift = k % n;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int newIndex;
                if (i % 2 == 0) {
                    newIndex = (j + shift) % n;
                } else {
                    newIndex = (j - shift + n) % n;
                }
                if (mat[i][j] != mat[i][newIndex]) return false;
            }
        }
        return true;
    }
}