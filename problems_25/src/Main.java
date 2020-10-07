import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
   public static void main(String[] args) {
      System.out.println(new Solution().solution(new int[]{1, 1, 9, 1, 1, 1} , 0));
   }
}

class Solution {
   public int solution(int[] priorities, int location) {
      int answer = 0;

      PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

      for (int priority : priorities) {
         queue.offer(priority);
      }

      while (!queue.isEmpty()){
         for (int i = 0; i < priorities.length; i++) {
            if(queue.peek() == priorities[i]){
               queue.poll();
               answer++;
               if(location == i){
                  queue.clear();
                  break;
               }
            }
         }
      }

      return answer;
   }
}
