import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().getRow(4));
    }
}

class Solution {
    private int getNum(int row, int col) {
        if (row == 0 || col == 0 || row == col) {
            return 1;
        }

        return getNum(row - 1, col - 1) + getNum(row - 1, col);
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i <= rowIndex; i++) {
            ans.add(getNum(rowIndex, i));
        }

        return ans;
    }
}
