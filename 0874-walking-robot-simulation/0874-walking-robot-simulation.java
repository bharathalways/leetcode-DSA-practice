class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        java.util.Set<String> set = new java.util.HashSet<>();
        for (int[] o : obstacles) {
            set.add(o[0] + "#" + o[1]);
        }

        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        int d = 0, x = 0, y = 0;
        int maxDist = 0;

        for (int cmd : commands) {
            if (cmd == -1) {
                d = (d + 1) % 4;
            } else if (cmd == -2) {
                d = (d + 3) % 4;
            } else {
                for (int i = 0; i < cmd; i++) {
                    int nx = x + dirs[d][0];
                    int ny = y + dirs[d][1];

                    if (set.contains(nx + "#" + ny)) break;

                    x = nx;
                    y = ny;

                    maxDist = Math.max(maxDist, x*x + y*y);
                }
            }
        }

        return maxDist;
    }
}