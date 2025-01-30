import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder ans = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = 0;

        for (int i = 2; i <= m; i += 2) {
            k++;
            ans.append(1).append(" ");
            ans.append(i).append(" ");
            ans.append(n).append(" ");
            ans.append(i).append("\n");
        }

        for (int i = 2; i <= n; i += 2) {
            k++;
            ans.append(i).append(" ");
            ans.append(1).append(" ");
            ans.append(i).append(" ");
            ans.append(m).append("\n");
        }

        System.out.println(k);
        System.out.println(ans);

        System.out.println();
    }
}