class Solution {
    public int distinctSubseqII(String s) {
        int MOD = 1_000_000_007;
        long[] dp = new long[s.length() + 1];
        long[] last = new long[26];

        dp[0] = 1;

        for (int i = 1; i <= s.length(); i++) {
            int c = s.charAt(i - 1) - 'a';

            long current = (2 * dp[i - 1] - last[c] + MOD) % MOD;

            last[c] = dp[i - 1];
            dp[i] = current;
        }

        return (int) ((dp[s.length()] - 1 + MOD) % MOD);
    }
}