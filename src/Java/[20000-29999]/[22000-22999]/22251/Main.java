import java.io.*;
import java.util.*;

public class Main {
    static Boolean[][] digit = new Boolean[10][7];
    static int n;
    static int k;
    static int p;
    static String x;

    public static int change(int a, int b) {
        int ret = 0;
        for (int i = 0; i < 7; i++) {
            if (digit[a][i] != digit[b][i]) ret++;
        }
        return ret;
    }

    public static String to_string(int x) {
        String num = String.valueOf(x);
        while (num.length() < k) {
            num = "0" + num;
        }
        return num;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        x = to_string(Integer.parseInt(st.nextToken()));

        digit[0] = new Boolean[]{true, true, true, false, true, true, true};
        digit[1] = new Boolean[]{false, false, true, false, false, true, false};
        digit[2] = new Boolean[]{true, false, true, true, true, false, true};
        digit[3] = new Boolean[]{true, false, true, true, false, true, true};
        digit[4] = new Boolean[]{false, true, true, true, false, true, false};
        digit[5] = new Boolean[]{true, true, false, true, false, true, true};
        digit[6] = new Boolean[]{true, true, false, true, true, true, true};
        digit[7] = new Boolean[]{true, false, true, false, false, true, false};
        digit[8] = new Boolean[]{true, true, true, true, true, true, true};
        digit[9] = new Boolean[]{true, true, true, true, false, true, true};

        int ans = 0;

        for (int i = 1; i < n + 1; i++) {
            String num = to_string(i);
            int temp = 0;
            for (int j = 0; j < k; j++) {
                int num1 = (int)x.charAt(j) - 48;
                int num2 = (int)num.charAt(j) - 48;
                temp += change(num1, num2);
                if (temp > p) break;
            }

            if (temp >= 1 && temp <= p) ans++;
        }

        System.out.println(ans);
    }
}