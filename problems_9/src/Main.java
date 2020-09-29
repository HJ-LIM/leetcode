public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().removeElement(new int[]{3,2,2,3} , 3));
        System.out.println(new Solution().removeElement(new int[]{0,1,2,2,3,0,4,2} , 2));
    }
}

class Solution {
    public int removeElement(int[] nums, int val) {

        int i = 0;

        for (int j = 0; j < nums.length; j++) {
            if(nums[j] != val){
                nums[i] = nums[j];
                i++;
            }
        }

        return i;
    }
}
