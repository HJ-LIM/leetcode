import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int l = 3;
        int r = 9;

        List<Integer> integers = new ArrayList<>();
        for (int i = l; i <= r ; i++) {
            if(i%2 == 1) integers.add(i);
        }

        integers.stream().forEach(integer -> {
            System.out.println(integer);
        });
    }
}
