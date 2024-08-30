import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word = br.readLine();

        word = word.replaceAll("c=", "C");
        word = word.replaceAll("c-", "C");
        word = word.replaceAll("dz=", "Z");
        word = word.replaceAll("d-", "Z");
        word = word.replaceAll("lj", "L");
        word = word.replaceAll("nj", "N");
        word = word.replaceAll("s=", "S");
        word = word.replaceAll("z=", "Z");

        System.out.println(word.length());
    }
}
