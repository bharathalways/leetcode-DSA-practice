import java.util.*;

class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        int[][] robots = new int[n][4];
        
        for (int i = 0; i < n; i++) {
            robots[i][0] = positions[i];
            robots[i][1] = healths[i];
            robots[i][2] = directions.charAt(i);
            robots[i][3] = i;
        }
        
        Arrays.sort(robots, (a, b) -> a[0] - b[0]);
        
        Stack<int[]> stack = new Stack<>();
        
        for (int[] r : robots) {
            if (r[2] == 'R') {
                stack.push(r);
            } else {
                while (!stack.isEmpty() && stack.peek()[2] == 'R' && r[1] > 0) {
                    if (stack.peek()[1] < r[1]) {
                        r[1]--;
                        stack.pop();
                    } else if (stack.peek()[1] > r[1]) {
                        stack.peek()[1]--;
                        r[1] = 0;
                    } else {
                        stack.pop();
                        r[1] = 0;
                    }
                }
                if (r[1] > 0) stack.push(r);
            }
        }
        
        List<int[]> survivors = new ArrayList<>(stack);
        survivors.sort(Comparator.comparingInt(a -> a[3]));
        
        List<Integer> res = new ArrayList<>();
        for (int[] r : survivors) res.add(r[1]);
        
        return res;
    }
}