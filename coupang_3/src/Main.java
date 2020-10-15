import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        System.out.println(new Solution().solution(new int[]{23, 61, 46}));
        long l = System.currentTimeMillis();
        System.out.println(new Solution().solution(new int[]{44, 33, 69, 62}) + " > " + (System.currentTimeMillis()-l) + " ms");
        System.out.println(new Solution().solution(new int[]{64, 77, 52, 43}) + " > " + (System.currentTimeMillis()-l) + " ms");
        System.out.println(new Solution().solution(new int[]{101, 100, 53, 65}) + " > " + (System.currentTimeMillis()-l) + " ms");
        System.out.println(new Solution().solution(new int[]{77, 88, 66, 55}) + " > " + (System.currentTimeMillis()-l) + " ms");
        System.out.println(new Solution().solution(new int[]{5, 6, 6, 10}) + " > " + (System.currentTimeMillis()-l) + " ms");
        System.out.println(new Solution().solution(new int[]{99, 98, 97, 96}) + " > " + (System.currentTimeMillis()-l) + " ms");
    }
}
class Solution {
    public int solution(int[] ages) {
        List<CandleSet> candleSets = new ArrayList<>();
        candleSets.add(new CandleSet());

        for (int i = 0; i < ages.length; i++) {
            String age = String.valueOf(ages[i]);
            for (int j = 0; j < age.length(); j++) {
                char num = age.charAt(j);

                boolean isRemove = false;
                for (CandleSet candleSet : candleSets) {
                    List<Character> candle_list = candleSet.getCandle();
                    if(candle_list.contains(num)){
                        candle_list.remove(candle_list.indexOf(num));
                        isRemove = true;
                    }else if(num == '6' && candle_list.contains('9')){
                        candle_list.remove(candle_list.indexOf('9'));
                        isRemove = true;
                    }else if(num == '9' && candle_list.contains('6')){
                        candle_list.remove(candle_list.indexOf('6'));
                        isRemove = true;
                    }
                    if(isRemove) break;
                }

                if(!isRemove){
                    CandleSet _candelSet = new CandleSet();
                    _candelSet.getCandle().remove(_candelSet.getCandle().indexOf(num));
                    candleSets.add(_candelSet);
                }
            }

        }

        return candleSets.size();
    }
}

class CandleSet{
    private List<Character> candle = new ArrayList<>();

    public CandleSet() {
        for (int i = 0; i < 10; i++) {
            candle.add((char)(i+'0'));
        }
    }

    public List<Character> getCandle() {
        return candle;
    }
}