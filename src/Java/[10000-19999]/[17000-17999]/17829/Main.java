import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] arr;

    static int div(int x, int y, int size) {
        if (size == 1) return arr[x][y];

        int next = size >> 1;
        int[] arr = {div(x, y, next), div(x + next, y, next), div(x, y + next, next), div(x + next, y + next, next)};
        Arrays.sort(arr);

        return arr[2];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(div(0, 0, N));
    }
}