public class Main {

   public static void main(String[] args) {
      System.out.println(new Solution().isPalindrome(10));
      System.out.println(new Solution().isPalindrome(24542));
      System.out.println(new Solution().isPalindrome(123321));
      System.out.println(new Solution().isPalindrome(-12321));
      System.out.println(new Solution().isPalindrome(12311));
   }
}

class Solution {
   public boolean isPalindrome(int x) {

      if(x < 0|| ( 10 <= x && x%10 == 0)){
         return false;
      }

      int halfValue = 0;

      while (x > halfValue){
         halfValue = (x%10) + (halfValue*10);
         x = x/10;
      }
      return (x == halfValue) || (x == halfValue/10);
   }
}