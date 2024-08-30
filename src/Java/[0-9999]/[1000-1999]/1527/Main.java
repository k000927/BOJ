import java.io.*;
import java.util.*;

public class Main {
    static int ans = 0;
    static int a;
    static int b;

    public static void dfs(String curNum) {
        long num = Long.parseLong(curNum);
        if(num > b) {
            return;
        }
        if (a <= num) {
            ans++;
        }
        dfs(curNum + "4");
        dfs(curNum + "7");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        dfs("4");
        dfs("7");
        System.out.println(ans);
    }
}