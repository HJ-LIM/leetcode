import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[]{1, 5, 2, 6, 3, 7, 4} , new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}}));
    }
}
/*
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = {};

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < commands.length; i++) {

            List<Integer> list = new ArrayList<>();
            int[] command = commands[i];
            int index = command[0]-1;
            int end = command[1]-1;

            while (index <= end){
                list.add(array[index]);
                index++;
            }

            Collections.sort(list);

            result.add(list.get(command[2]-1));
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}*/

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i=0; i<commands.length; i++){
            int[] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(temp);
            answer[i] = temp[commands[i][2]-1];
        }

        return answer;
    }
}