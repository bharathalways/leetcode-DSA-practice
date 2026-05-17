import java.util.*;

class Solution {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;

        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();

        q.offer(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int curr = q.poll();

            if (arr[curr] == 0) {
                return true;
            }

            int forward = curr + arr[curr];
            int backward = curr - arr[curr];

            if (forward < n && !visited[forward]) {
                visited[forward] = true;
                q.offer(forward);
            }

            if (backward >= 0 && !visited[backward]) {
                visited[backward] = true;
                q.offer(backward);
            }
        }

        return false;
    }
}