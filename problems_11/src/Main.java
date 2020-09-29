public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().searchInsert(new int[]{1,3,5,6} , 5));
        System.out.println(new Solution().searchInsert(new int[]{1,3,5,6} , 2));
        System.out.println(new Solution().searchInsert(new int[]{1,3,5,6} , 7));
        System.out.println(new Solution().searchInsert(new int[]{1,3,5,6} , 0));
    }
}

class Solution {
    public int searchInsert(int[] nums, int target) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if(target < nums[i]) return index;
            else if(target == nums[i]) return i;
            else index++;
        }
        return index;
    }
}
