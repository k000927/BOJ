import java.io.*;
import java.util.*;

public class Main {
    static int n, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        if (n == k) ans.append("Impossible");
        else {
            ans.append(n - k).append(' ');
            for (int i = 1; i < n-k; i++) ans.append(i).append(' ');
            for (int i = n-k+1; i <= n; i++) ans.append(i).append(' ');
        }

        System.out.println(ans);
    }
}