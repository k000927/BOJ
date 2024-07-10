import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int max = 0;
        int min = 1000;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int score = Integer.parseInt(st.nextToken());
            max = Math.max(score, max);
            min = Math.min(score, min);
        }

        System.out.println(max - min);
    }
}
