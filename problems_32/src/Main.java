import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<List<Integer>> lists = Result.groupSort(new ArrayList<>(Arrays.asList(2, 73, 69, 54, 27, 65, 12, 44, 46, 96, 88, 27, 51, 18, 92, 88, 30, 64, 61, 16, 77, 54, 78, 54, 1, 33, 2, 93, 88, 84, 31, 6, 88, 95, 9, 49, 7, 77, 77, 13, 48, 55, 27, 88, 43, 22, 54, 73, 21, 32, 100, 65, 44, 52, 13, 23, 34, 59, 24, 23, 8, 64, 23, 91, 86, 8, 24, 67, 22, 14, 94, 58, 48, 79, 81, 20, 10, 44, 43, 47, 73, 68, 99, 10, 41, 34, 87, 25, 20, 45, 43, 28, 25, 93, 45, 87, 56, 6, 100, 84)));

        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer + " ,");
            }
            System.out.println("");
        }
    }
}

class Result {

    /*
     * Complete the 'groupSort' function below.
     *
     * The function is expected to return a 2D_INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<List<Integer>> groupSort(List<Integer> arr) {
        // Write your code here
        Map<Integer, IntegerGroup> map = new HashMap<>();

        for (Integer integer : arr) {
            if(map.containsKey(integer)){
                IntegerGroup integerGroup = map.get(integer);
                integerGroup.add();
                map.put(integer, integerGroup);
            }else{
                map.put(integer , new IntegerGroup(integer));
            }
        }

        List<Map.Entry<Integer, IntegerGroup>> list = sort(map);

        List<List<Integer>> result = new ArrayList<>();

        // generate return type
        for (Map.Entry<Integer, IntegerGroup> entry : list) {
            List<Integer> integers = new ArrayList<>();
            integers.add(entry.getValue().getValue());
            integers.add(entry.getValue().getCount());
            result.add(integers);
        }

        return result;
    }

    public static List<Map.Entry<Integer, IntegerGroup>> sort(Map<Integer, IntegerGroup> map){

        List<Map.Entry<Integer, IntegerGroup>> entries = new LinkedList<>(map.entrySet());
        Collections.sort(entries , (o1, o2) -> {
            int order = 1;
            // 1. 카운터가 큰 경우
            // 2. 카운터가 동일 할 경우 value 가 작음
            if(o1.getValue().getCount() > o2.getValue().getCount() ||
                (o1.getValue().getCount() == o2.getValue().getCount() && o1.getValue().getValue() < o2.getValue().getValue())){
                order = -1;
            }
            return order;
        });

        return entries;
    }
}

class IntegerGroup{
    private int value;
    private int count;

    public IntegerGroup(int value) {
        this.value = value;
        this.count =1;
    }

    public void add(){
        this.count++;
    }

    public int getValue() {
        return value;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString(){
        return "["+this.value+" , "+this.count+"]";
    }
}