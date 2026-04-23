import java.util.*;

class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        
        long[] res = new long[n];
        
        for (List<Integer> list : map.values()) {
            int m = list.size();
            
            long[] prefix = new long[m];
            prefix[0] = list.get(0);
            
            for (int i = 1; i < m; i++) {
                prefix[i] = prefix[i - 1] + list.get(i);
            }
            
            for (int i = 0; i < m; i++) {
                long left = 0, right = 0;
                int idx = list.get(i);
                
                if (i > 0) {
                    left = (long) idx * i - prefix[i - 1];
                }
                
                if (i < m - 1) {
                    right = (prefix[m - 1] - prefix[i]) - (long) idx * (m - i - 1);
                }
                
                res[idx] = left + right;
            }
        }
        
        return res;
    }
}