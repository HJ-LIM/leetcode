import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
   public static void main(String[] args) {
      System.out.println(new Solution().solution(new int[][]{{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}} , new int[]{1,5,3,5,1,2,1,4}));
   }
}

class Solution {
   public int solution(int[][] board, int[] moves) {
      int answer = 0;

      Map<Integer, ArrayList<Integer>> map = generateMap(board);

      List<Integer> basket = new ArrayList<>();

      for (int i = 0; i < moves.length; i++) {
         ArrayList<Integer> integers = map.get(moves[i]);
         if(integers.size() == 0 ) continue;
         Integer doll = integers.get(integers.size() - 1);
         integers.remove(integers.size() - 1);


         if(basket.size() != 0 && basket.get(basket.size()-1) == doll){
            basket.remove(basket.size()-1);
            answer += 2;
         }else{
            basket.add(doll);
         }

      }

      return answer;
   }

   private Map<Integer, ArrayList<Integer>> generateMap(int[][] board) {
      HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

      for (int i = board.length-1; i >= 0; i--) {
         int[] floor = board[i];

         for (int j = 0; j < floor.length; j++) {
            ArrayList<Integer> arr;

            if(map.containsKey(j + 1)){
               arr = map.get(j + 1);
            }else{
               arr = new ArrayList<>();
            }

            if(floor[j] == 0 ) continue;
            
            arr.add(floor[j]);
            map.put(j+1 , arr);
         }
      }

      return map;
   }
}