import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Arrays.stream(new Solution().middleNode(new int[]{1, 2, 3, 4, 5})).forEach(System.out::print);
        System.out.println();
        Arrays.stream(new Solution().middleNode(new int[]{1, 2, 3, 4, 5,6})).forEach(System.out::print);
        System.out.println();
        Arrays.stream(new Solution().middleNode(new int[]{1, 2, 3, 4, 5,6,7,8})).forEach(System.out::print);
        System.out.println();
        Arrays.stream(new Solution().middleNode(new int[]{1, 2, 3, 4, 5,6,7,8,9,10,11})).forEach(System.out::print);
    }
}

class Solution {
    public int[] middleNode(int[] head) {

        List<Integer> arr = new ArrayList<>();

        int middle = head.length/2;

        for (int i = middle; i < head.length; i++) {
            arr.add(head[i]);
        }

        return arr.stream().mapToInt(Integer::intValue).toArray();
    }
}
