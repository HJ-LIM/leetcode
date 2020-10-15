import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        new Solution().generate(4);
    }
}

class Solution {
    public List<List<Integer>> generate(int numRows) {
        ArrayList<List<Integer>> result = new ArrayList<>();

        if(numRows == 0){
            return result;
        }

        result.add(new ArrayList<>());
        result.get(0).add(1);

        for (int rowNum = 1; rowNum < numRows; rowNum++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> pre_row = result.get(rowNum - 1);

            row.add(1);

            for (int i = 1; i < rowNum; i++) {
                row.add(pre_row.get(i-1) + pre_row.get(i));
            }

            row.add(1);
            result.add(row);
        }
        return result;
    }
}