package perfect_hashing;

import java.util.ArrayList;
import java.util.Random;

public class Try {
    public static void main(String[] args) {
        ONspace h = new ONspace();
        Random random = new Random();
        Integer[] keys = new Integer[10];
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            keys[i] = random.nextInt();
            arrayList.add(keys[i]);
        }
        h.hash(keys);
        for (int i = 0; i < 10; i++) {
            System.out.println(h.contains(keys[i]) == true);
            System.out.println(h.contains(random.nextInt()) == false);
        }
    }
}
