import java.util.*;

class Fancy {

    static final long MOD = 1000000007;

    List<Long> list;
    long mul;
    long add;

    public Fancy() {
        list = new ArrayList<>();
        mul = 1;
        add = 0;
    }

    public void append(int val) {

        long stored = (val - add) % MOD;
        if (stored < 0) stored += MOD;

        stored = stored * modInverse(mul) % MOD;

        list.add(stored);
    }

    public void addAll(int inc) {
        add = (add + inc) % MOD;
    }

    public void multAll(int m) {
        mul = (mul * m) % MOD;
        add = (add * m) % MOD;
    }

    public int getIndex(int idx) {

        if (idx >= list.size()) return -1;

        long val = list.get(idx);
        val = (val * mul % MOD + add) % MOD;

        return (int) val;
    }

    private long modInverse(long x) {
        return power(x, MOD - 2);
    }

    private long power(long x, long y) {

        long res = 1;
        x %= MOD;

        while (y > 0) {

            if ((y & 1) == 1)
                res = (res * x) % MOD;

            x = (x * x) % MOD;
            y >>= 1;
        }

        return res;
    }
}