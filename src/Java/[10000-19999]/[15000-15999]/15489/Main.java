import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int[][] pascal = new int[31][31];
        for (int i = 1; i < 30; i++) {
            pascal[i][1] = 1;
        }

        for (int i = 2; i < 30; i++) {
            for (int j = 2; j < i; j++) {
                pascal[i][j] = pascal[i - 1][j - 1] + pascal[i - 1][j];
            }
            pascal[i][i] = 1;
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int ans = 0;

        for (int i = r; i < r + w; i++) {
            for (int j = c; j < c + i - r + 1; j++) {
                ans += pascal[i][j];
            }
        }

        System.out.println(ans);
    }
}
