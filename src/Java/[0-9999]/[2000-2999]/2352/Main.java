import java.io.*;
import java.util.*;

public class Main {
    static int n, len;
    static int[] lis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        len = 0;
        lis = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            int pos = Arrays.binarySearch(lis, 0, len, num);
            if (pos < 0) pos = -pos - 1; // lower_bound 위치
            lis[pos] = num;
            if (pos == len) len++;
        }

        System.out.println(len);
    }
}