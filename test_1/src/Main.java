import java.util.*;

public class Main {
    public static void main(String[] args) {
        long[] solution = new Solution().solution(new String[]{"one", "one", "two", "one"});
        for (int i = 0; i < solution.length; i++) {
            System.out.print(solution[i]);
        }
    }
}

class Solution {
    public long[] solution(String[] words) {
        long[] answer = new long[words.length];

        Map<String, Integer> temp = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if(temp.containsKey(word)){
                answer[i] = temp.get(word);
            }else{
                answer[i] = i+1;
                temp.put(word, i+1);
            }
        }

        return answer;
    }
}