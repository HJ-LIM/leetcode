import java.util.HashMap;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().isValid("()[]{}"));
        System.out.println(new Solution().isValid("(((())))"));
        System.out.println(new Solution().isValid("([{}])"));


    }
}

class Solution {
    public boolean isValid(String s) {
        if(s.length()%2 != 0) return false;

        HashMap<Character, Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');


        Stack<Character> characters = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))){
                char topElement = characters.empty() ? '#' : characters.pop();

                if (topElement != map.get(s.charAt(i))) {
                    return false;
                }
            }else{
                characters.push(s.charAt(i));
            }

        }
        return characters.isEmpty();
    }
}
