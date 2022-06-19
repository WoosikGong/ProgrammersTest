import java.math.BigInteger;

class Solution {
    public long solution(int w, int h) {
        long answer = 1;

        BigInteger a = BigInteger.valueOf(w);
        BigInteger b = BigInteger.valueOf(h);
        int gcd = a.gcd(b).intValue();

        answer = (long)w*h-( w/gcd + h/gcd - 1) * gcd;

        return answer;
    }
}