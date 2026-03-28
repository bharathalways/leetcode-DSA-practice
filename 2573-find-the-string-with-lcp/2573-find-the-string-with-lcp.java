class Solution {
    int[] parent;

    int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }

    void union(int a, int b) {
        int pa = find(a), pb = find(b);
        if (pa != pb)
            parent[pb] = pa;
    }

    public String findTheString(int[][] lcp) {
        int n = lcp.length;
        parent = new int[n];

        for (int i = 0; i < n; i++) parent[i] = i;

        for (int i = 0; i < n; i++) {
            if (lcp[i][i] != n - i) return "";
            for (int j = i + 1; j < n; j++) {
                if (lcp[i][j] != lcp[j][i]) return "";
                if (lcp[i][j] > 0) union(i, j);
            }
        }

        char[] res = new char[n];
        int[] map = new int[n];
        Arrays.fill(map, -1);

        int ch = 0;

        for (int i = 0; i < n; i++) {
            int p = find(i);
            if (map[p] == -1) {
                if (ch >= 26) return "";
                map[p] = ch++;
            }
            res[i] = (char) ('a' + map[p]);
        }

        int[][] dp = new int[n + 1][n + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (res[i] == res[j])
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                else
                    dp[i][j] = 0;

                if (dp[i][j] != lcp[i][j]) return "";
            }
        }

        return new String(res);
    }
}