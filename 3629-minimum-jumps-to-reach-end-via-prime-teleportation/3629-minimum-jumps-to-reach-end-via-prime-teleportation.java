class Solution {

    public int minJumps(int[] nums) {
        int n = nums.length;

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            List<Integer> factors = primeFactors(nums[i]);

            for (int p : factors) {
                map.computeIfAbsent(p, k -> new ArrayList<>()).add(i);
            }
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n];
        Set<Integer> usedPrime = new HashSet<>();

        q.offer(0);
        vis[0] = true;

        int steps = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            while (size-- > 0) {

                int idx = q.poll();

                if (idx == n - 1) {
                    return steps;
                }

                if (idx - 1 >= 0 && !vis[idx - 1]) {
                    vis[idx - 1] = true;
                    q.offer(idx - 1);
                }

                if (idx + 1 < n && !vis[idx + 1]) {
                    vis[idx + 1] = true;
                    q.offer(idx + 1);
                }

                int val = nums[idx];

                if (isPrime(val) && !usedPrime.contains(val)) {

                    usedPrime.add(val);

                    List<Integer> next = map.getOrDefault(val, new ArrayList<>());

                    for (int ni : next) {

                        if (!vis[ni]) {
                            vis[ni] = true;
                            q.offer(ni);
                        }
                    }
                }
            }

            steps++;
        }

        return -1;
    }

    private boolean isPrime(int x) {

        if (x < 2) {
            return false;
        }

        for (int i = 2; i * i <= x; i++) {

            if (x % i == 0) {
                return false;
            }
        }

        return true;
    }

    private List<Integer> primeFactors(int x) {

        List<Integer> list = new ArrayList<>();

        for (int i = 2; i * i <= x; i++) {

            if (x % i == 0) {

                list.add(i);

                while (x % i == 0) {
                    x /= i;
                }
            }
        }

        if (x > 1) {
            list.add(x);
        }

        return list;
    }
}