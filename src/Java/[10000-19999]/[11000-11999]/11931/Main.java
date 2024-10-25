import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[1000000 * 2 + 1];
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[num + 1000000]++;
        }

        for (int i = 2000000; i >= 0; i--) {
            if (arr[i] == 0) continue;
            System.out.println(i - 1000000);
        }
    }
}