package perfect_hashing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\NEXT STORE\\eclipse-workspace\\perfect_hashing\\src\\perfect_hashing\\keys.txt";
        FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = bufferedReader.readLine();
        int[] numbers = Arrays.stream(line.split(",")).mapToInt(num -> Integer.parseInt(num)).toArray();
        Integer[] keys = Arrays.stream(numbers).boxed().toArray( Integer[]::new );
        System.out.println("Hashing "+keys.length+" Key");
        ONspace ONspace = new ONspace();
        ON2space ON2space = new ON2space();
        System.out.println("\nO(N) space: ");
        ONspace.hash(keys);
        System.out.println("\nO(N^2) space: ");
        ON2space.hash(keys);
        bufferedReader.close();
    }
}
