import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[] bugs = new int[4];

    public static void january(int year) {
        int newBugs = bugs[0] + bugs[1] + bugs[2] + bugs[3];
        bugs[0] = bugs[1];
        bugs[1] = bugs[2];
        bugs[2] = bugs[3];
        bugs[3] = 0;

        if (year % 2 == 0) bugs[3] += newBugs;
        else bugs[2] += newBugs;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Arrays.fill(bugs, 0);
        bugs[2] = 1;


        for (int i = 2; i < n + 1; i++) {
            january(i);
        }
        System.out.println(bugs[0] + bugs[1] + bugs[2] + bugs[3]);
    }
}
