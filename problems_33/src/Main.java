import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().solution("abcdcba") == 7);
//        System.out.println(new Solution().solution("abacde") == 3);
        System.out.println(new Solution().solution("abcabcdcbae") == 7);
        System.out.println(new Solution().solution("aaaa") == 4);
        System.out.println(new Solution().solution("abcbaqwertrewqq") == 9);
        System.out.println(new Solution().solution("a") == 1);
        System.out.println(new Solution().solution("abaabaaaaaaa") == 7);
    }
}

//class Solution {
//    public int solution(String s){
//        int answer = 0;
//
//        if(s.length() == 1){
//            return 1;
//        }
//
//        StringBuffer reverse_str = new StringBuffer(s);
//        reverse_str.reverse();
//
//        for (int i = 0; i < reverse_str.length(); i++) {
//            char reverse_char = reverse_str.charAt(i);
//
//            boolean check = false;
//            for (int j = 0; j < s.length(); j++) {
//
//                char c = s.charAt(j);
//
//                if(reverse_char == c){
//                    if(i == j || (i/2)-1 == j){
//                        check = true;
//                        break;
//                    }
//                }
//            }
//
//            if(check){
//                return reverse_str.length()-i;
//            }
//        }
//
//        return answer;
//    }
//}

class Solution
{
    public int solution(String s)
    {
        char[] chr = s.toCharArray();

        // 가장 긴 문자열부터 팰린드롬 검사
        for (int leng = s.length(); leng > 1; leng--) {

            // 시작 인덱스
            for (int start = 0; start + leng <= s.length(); start++) {
                boolean chk = true;

                // 처음부터 문자열 길이의 반틈만큼 문자가 같은지 비교
                for (int i = 0; i < leng/2; i++) {
                    if (chr[start + i] != chr[start + leng  - i - 1]) {
                        chk = false;
                        break;
                    }
                }

                if (chk) return leng;
            }
        }

        return 1;
    }
}
