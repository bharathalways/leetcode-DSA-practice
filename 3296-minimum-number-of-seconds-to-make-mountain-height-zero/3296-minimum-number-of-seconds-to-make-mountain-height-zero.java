import java.util.*;

class Solution {

    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {

        long left = 0;
        long right = (long)1e18;
        long ans = right;

        while (left <= right) {

            long mid = (left + right) / 2;

            if (can(mid, mountainHeight, workerTimes)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    private boolean can(long time, int mountainHeight, int[] workerTimes) {

        long total = 0;

        for (int t : workerTimes) {

            long left = 0, right = 100000;

            while (left <= right) {

                long mid = (left + right) / 2;
                long needed = t * mid * (mid + 1) / 2;

                if (needed <= time) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            total += right;

            if (total >= mountainHeight)
                return true;
        }

        return total >= mountainHeight;
    }
}