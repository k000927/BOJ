import java.io.*;
import java.util.*;

public class Main {
    static int N, H;
    static int[] obstacle;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        obstacle = new int[H + 1];

        int stalactite, stalagmite;
        for (int i = 0; i < N; i += 2) {
            stalactite = Integer.parseInt(br.readLine());
            obstacle[0]++;
            obstacle[stalactite]--;

            stalagmite = Integer.parseInt(br.readLine());
            obstacle[H - stalagmite]++;
            obstacle[H]--;
        }

        int min = Integer.MAX_VALUE, count = 0, sum = 0;
        for (int i = 0; i < H; i++) {
            sum += obstacle[i];
            if(min == sum) count++;
            else if (min > sum) {
                min = sum;
                count = 1;
            }
        }

        System.out.println(min + " " + count);
    }
}