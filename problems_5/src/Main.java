public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().longestCommonPrefix(new String[]{"flower","flow","flight"}));
        System.out.println(new Solution().longestCommonPrefix(new String[]{"developer","develop","dev"}));
    }
}

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        if(strs.length == 1) return strs[0];

        StringBuffer sb = new StringBuffer();

        String base = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(base) != 0){
                base = base.substring(0 , base.length() -1);
                if(base.isEmpty()) return "";
            }
        }

        return base;
    }
}
