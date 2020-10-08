import java.util.HashMap;

public class Main {

   public static void main(String[] args) {
      System.out.println(new Solution().solution(10));
   }
}

class Solution {
   public String solution(int n) {
      String answer = "";

      String[] str = {"4", "1", "2"};

      while (n > 0){
         int remain = n%3;
         n /= 3;

         if(remain == 0) n--;

         answer = str[remain] + answer;
      }


      return answer;
   }
}