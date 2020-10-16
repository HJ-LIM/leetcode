import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(3, "hi bye" , 3));
        System.out.println(new Solution().solution(5, "hi bye" , 5));
        System.out.println(new Solution().solution(10, "hi bye" , 10));
        System.out.println(new Solution().solution(6, "hi bye" , 300));
        System.out.println(new Solution().solution(6, "hi bye" , 600));
    }
}

class Solution {
    public String solution(int n, String text, int second) {
        StringBuffer answer = new StringBuffer();

        for (int i = 0; i < n; i++) {
            answer.append("_");
        }
        answer.append(text.replaceAll(" " , "_"));

        for (int i = 0; i < second; i++) {
            answer.append(answer.charAt(0));
            answer.delete(0, 1);
        }

        return answer.substring(0 , n).toString();
    }
}

//class Solution {
//    public String solution(int n, String text, int second) {
//        StringBuffer answer = new StringBuffer();
//        answer.append(String.format("%"+n+"s" , " ").replace(" " , "_"));
//        answer.append(text.replaceAll(" " , "_"));
//
//        for (int i = 0; i < second; i++) {
//            answer.append(answer.charAt(0));
//            answer.delete(0, 1);
//        }
//
//        return answer.substring(0 , n).toString();
//    }
//}