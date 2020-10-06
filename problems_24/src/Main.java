import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class Main {

   public static void main(String[] args) {
      System.out.println(new Solution().solution("CBD" , new String[]{"BACDE", "CBADF", "AECB", "BDA"} ));
   }

}

//class Solution {
//   public int solution(String skill, String[] skill_trees) {
//      int answer = 0;
//
//      for (int i = 0; i < skill_trees.length; i++) {
//         String[] tree = skill_trees[i].split("");
//
//         boolean isFlag = true;
//         int index = 0;
//         for (int j = 0; j < tree.length; j++) {
//            String _skill = tree[j];
//
//            if(index == skill.indexOf(_skill)){
//               index++;
//            }else if(index < skill.indexOf(_skill)){
//               isFlag = false;
//               break;
//            }
//         }
//
//         if(isFlag) answer++;
//      }
//
//      return answer;
//   }
//}

class Solution {
   public int solution(String skill, String[] skill_trees) {
      int answer = 0;
      ArrayList<String> skillTrees = new ArrayList<String>(Arrays.asList(skill_trees));
      Iterator<String> it = skillTrees.iterator();


      // 정규식으로 처리..
      while (it.hasNext()) {
         if (skill.indexOf(it.next().replaceAll("[^" + skill + "]", "")) != 0) {
            it.remove();
         }
      }
      answer = skillTrees.size();
      return answer;
   }
}