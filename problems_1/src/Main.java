import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws Exception {
        int[] ints = new Solution().twoSum(new int[]{2,7,11,15}, 9);
        System.out.println(ints[0] +","+ ints[1]);
    }
}


class Solution {
    public int[] twoSum(int[] nums, int target) throws Exception {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int second_value = target - nums[i];

            if(map.containsKey(second_value)){
                return new int[]{ i , map.get(second_value)};
            }
            map.put(nums[i] , i);

        }

        throw new IllegalArgumentException("No two sum solution");
    }
}