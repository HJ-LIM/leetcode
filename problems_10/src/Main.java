public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().strStr("a" , "a"));
    }
}

class Solution {
    public int strStr(String haystack, String needle) {

        if(needle.length() == 0) return 0;

        if(haystack.indexOf(needle) > -1){
            return haystack.indexOf(needle);
        }
        return -1;
    }
}
