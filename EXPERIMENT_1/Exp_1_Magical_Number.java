class Solution {

    static long gcd(long a, long b){
        if(b == 0) return a;
        return gcd(b, a % b);
    }

    public int nthMagicalNumber(int n, int a, int b) {

        long mod = 1000000007;

        long l = 1;
        long h = (long)n * Math.min(a,b);

        long lcm = (long)a * b / gcd(a,b);

        while(l < h){
            long mid = l + (h-l)/2;

            long cnt = mid/a + mid/b - mid/lcm;

            if(cnt < n)
                l = mid + 1;
            else
                h = mid;
        }

        return (int)(l % mod);
    }
}
