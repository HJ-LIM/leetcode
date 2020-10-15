public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().climbStairs(4));
    }
}

class Solution {
//    public int climbStairs(int n) {
//        return climb_Stairs(0, n);
//    }
//    public int climb_Stairs(int i, int n) {
//        if (i > n) {
//            return 0;
//        }
//        if (i == n) {
//            return 1;
//        }
//        return climb_Stairs(i + 1, n) + climb_Stairs(i + 2, n);
//    }

    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }
}
