import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static StringBuilder ans;

    static void div(int start, int size) {
        if (size == 1) return;
        int next = size / 3;

        for (int i = start + next; i < start + next * 2; i++) {
            ans.setCharAt(i, ' ');
        }

        div(start, next);
        div(start + next * 2, next);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            ans = new StringBuilder();
            N = Integer.parseInt(str);
            int len = (int) Math.pow(3, N);
            for (int i = 0; i < len; i++) {
                ans.append("-");
            }

            div(0, len);
            System.out.println(ans);
        }
    }
}