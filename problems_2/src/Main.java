public class Main {
   public static void main(String[] args) {
      int reverse = new Solution().reverse(-234);
      System.out.println(reverse);
   }
}

class Solution {
   public int reverse(int x) {

      String str = String.valueOf(x);
      String reverse_value = x < 0 ? "-"+new StringBuffer(str).reverse().substring(0 , str.length()-1).toString() :
          new StringBuffer(str).reverse().toString();

      try {
         return Integer.valueOf(reverse_value);
      } catch (NumberFormatException e) {
         return 0;
      }
   }
}
