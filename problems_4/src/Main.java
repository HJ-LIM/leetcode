import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().romanToInt("MCMXCIV"));
        System.out.println(new Solution().romanToInt("IV"));
        System.out.println(new Solution().romanToInt("VI"));
        System.out.println(new Solution().romanToInt("IX"));
        System.out.println(new Solution().romanToInt("XII"));
    }
}

class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I' , 1);
        map.put('V' , 5);
        map.put('X' , 10);
        map.put('L' , 50);
        map.put('C' , 100);
        map.put('D' , 500);
        map.put('M' , 1000);

        int len = s.length();
        int value = map.get(s.charAt(len-1));
        for (int i = len - 2; i >= 0; i--) {
            if(map.get(s.charAt(i)) >= map.get(s.charAt(i + 1))){
                value += map.get(s.charAt(i));
            }else{
                value -= map.get(s.charAt(i));
            }
        }

        return value;
    }
}