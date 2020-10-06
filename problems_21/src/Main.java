import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main {
   public static void main(String[] args) {
      System.out.println(new Solution().solution(new int[][]{{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}} , new int[]{1,5,3,5,1,2,1,4}));
   }
}

class Solution {
   public int solution(int[][] board, int[] moves) {
      int answer = 0;

      Map<Integer, Stack<Integer>> temp_map = generateMap(board);

      Stack<Integer> basket = new Stack<>();
//      List<Integer> basket = new ArrayList<>();

      for (int i = 0; i < moves.length; i++) {
         Stack<Integer> temp = temp_map.get(moves[i]);
         if(temp.size() == 0 ) continue;
         Integer doll = temp.peek();
         temp.pop();

         if(basket.size() != 0 && basket.peek() == doll){
            basket.pop();
            answer += 2;
         }else{
            basket.push(doll);
         }

      }

      return answer;
   }

   private Map<Integer, Stack<Integer>> generateMap(int[][] board) {
      HashMap<Integer, Stack<Integer>> map = new HashMap<>();

      for (int i = board.length-1; i >= 0; i--) {
         int[] floor = board[i];

         for (int j = 0; j < floor.length; j++) {
            Stack<Integer> stack;

            if(map.containsKey(j + 1)){
               stack = map.get(j + 1);
            }else{
               stack = new Stack<>();
            }

            if(floor[j] == 0 ) continue;
            stack.push(floor[j]);
            map.put(j+1 , stack);
         }
      }

      return map;
   }
}