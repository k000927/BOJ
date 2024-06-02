import java.io.*;
import java.util.*;

public class Main {
    static PriorityQueue<String> ans;

    public static void calculator(String x) {
        String exp = x.replace(" ", "");
        int sum = 0;
        int index = 0;
        while (index < exp.length()) {
            String num = "";
            if (exp.charAt(index++) == '+') {
                while (true) {
                    if (index == exp.length()) break;
                    if (exp.charAt(index) == '+' || exp.charAt(index) == '-') break;
                    num += exp.charAt(index++);
                }
                sum += Integer.parseInt(num);
            } else {
                while (true) {
                    if (index == exp.length()) break;
                    if (exp.charAt(index) == '+' || exp.charAt(index) == '-') break;
                    num += exp.charAt(index++);
                }
                sum -= Integer.parseInt(num);
            }
        }
        if (sum == 0) ans.add(x.substring(1));
    }

    public static void recursive(int target, int cur, String exp) {
        if (target == cur) calculator(exp);
        else {
            recursive(target, cur + 1, exp + " " + String.valueOf(cur + 1));
            recursive(target, cur + 1, exp + "+" + String.valueOf(cur + 1));
            recursive(target, cur + 1, exp + "-" + String.valueOf(cur + 1));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        for (int z = 0; z < t; z++) {
            ans = new PriorityQueue<>();

            int n = Integer.parseInt(br.readLine());
            recursive(n, 1, "+1");

            while (!ans.isEmpty()) {
                bw.write(ans.poll() + '\n');
            }
            bw.write('\n');
        }
        bw.flush();
    }
}
