import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int money = 1000 - Integer.parseInt(br.readLine());
        int[] coin = {500, 100, 50, 10, 5, 1};

        int ans = 0;
        for (int i = 0; i < 6; i++) {
            int temp = money / coin[i];
            ans += temp;
            money -= temp * coin[i];
        }

        System.out.println(ans);
    }
}