public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println(new Solution().mySqrt(12));
    }
}

class Solution {
    public int mySqrt(int x) {
        int left = (int)Math.pow(Math.E, 0.5 * Math.log(x));
        System.out.println(left);
        int right = left + 1;
        return (long)right * right > x ? left : right;
    }
}