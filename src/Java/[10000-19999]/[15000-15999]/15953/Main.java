import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int price = 0;

            if (a == 0) price += 0;
            else if (a <= 1) price += 5000000;
            else if (a <= 3) price += 3000000;
            else if (a <= 6) price += 2000000;
            else if (a <= 10) price += 500000;
            else if (a <= 15) price += 300000;
            else if (a <= 21) price += 100000;

            if (b == 0) price += 0;
            else if (b <= 1) price += 5120000;
            else if (b <= 3) price += 2560000;
            else if (b <= 7) price += 1280000;
            else if (b <= 15) price += 640000;
            else if (b <= 31) price += 320000;

            System.out.println(price);
        }
    }
}