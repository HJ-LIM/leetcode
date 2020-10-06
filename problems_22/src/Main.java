import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class Main {
   public static void main(String[] args) {
      Arrays.stream((new Solution().solution(new int[]{2,1,3,4,1}))).forEach(System.out::print);
   }
}

//class Solution {
//   private List<Integer> temp = new ArrayList<>();
//   public int[] solution(int[] numbers) {
//      int[] answer = {};
//
//
//      for (int i = 0; i < numbers.length; i++) {
//         two_sum(i , numbers[i], numbers);
//      }
//
//      Collections.sort(temp);
//
//      answer = new int[temp.size()];
//      for (int i = 0; i < temp.size(); i++) {
//         answer[i]= temp.get(i);
//      }
//
//      return answer;
//   }
//
//   private void two_sum(int index , int number, int[] numbers) {
//      for (int i = index+1; i < numbers.length; i++) {
//         int sum = number + numbers[i];
//
//         if(temp.contains(sum)) continue;
//         temp.add(sum);
//      }
//   }
//}

class Solution {
   public int[] solution(int[] numbers) {
      Set<Integer> set = new HashSet<>();

      for(int i=0; i<numbers.length; i++) {
         for(int j=i+1; j<numbers.length; j++) {
            set.add(numbers[i] + numbers[j]);
         }
      }

      return set.stream().sorted().mapToInt(Integer::intValue).toArray();
   }
}