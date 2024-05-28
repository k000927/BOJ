import java.io.*;
import java.util.*;

public class Main {
    public static String rev(String a) {
        if (a.equals("0")) return "1";
        else return "0";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] init = (br.readLine() + "0").split("");
        String[] target = (br.readLine() + "0").split("");

        String[] press = new String[n + 1];
        String[] not_press = new String[n + 1];

        for (int i = 0; i < n + 1; i++) {
            press[i] = init[i];
            not_press[i] = init[i];
        }
        press[0] = rev(press[0]);
        press[1] = rev(press[1]);
        int ans1 = 1;
        int ans2 = 0;

        for (int i = 1; i < n; i++) {
            if (!target[i - 1].equals(press[i - 1])) {
                press[i - 1] = rev(press[i - 1]);
                press[i] = rev(press[i]);
                press[i + 1] = rev(press[i + 1]);
                ans1++;
            }
            if (!target[i - 1].equals(not_press[i - 1])) {
                not_press[i - 1] = rev(not_press[i - 1]);
                not_press[i] = rev(not_press[i]);
                not_press[i + 1] = rev(not_press[i + 1]);
                ans2++;
            }
        }

        int ans = -1;

        if (target[n - 1].equals(press[n - 1])) ans = ans1;
        if (target[n - 1].equals(not_press[n - 1])) {
            if(ans != -1) ans = Math.min(ans, ans2);
            else ans = ans2;
        }
        System.out.println(ans);
    }
}