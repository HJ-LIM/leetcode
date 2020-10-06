import java.math.BigInteger;

public class Main {
   public static void main(String[] args) {
      System.out.println(new Solution().solution(8,12));
   }
}

//class Solution {
//   public long solution(int w, int h) {
//      Long _w = Long.valueOf(w);
//      Long _h = Long.valueOf(h);
//
//      long small, big;
//      big = _w >= _h ? _w : _h;
//      small = _w < _h ? _w : _h;
//
//      while (small != 0){
//         long remain = big % small;
//         big = small;
//         small = remain;
//      }
//      return (_w * _h) - (_w + _h -big);
//
//   }
//}

class Solution {
   public long solution(int w, int h) {
      long totalCount = (long) w * (long) h;
      long diagonalCount = w + h - BigInteger.valueOf(w).gcd(BigInteger.valueOf(h)).longValue();

      return totalCount - diagonalCount;
   }
}