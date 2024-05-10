import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        String str = br.readLine();

        int ans = 0;
        for (int i = 0; i < n; i++) {
            char c = str.charAt(i);
            if (c == 'P') {
                int start = Math.max(0, i - k);
                int end = Math.min(n - 1, i + k);
                for (int index = start; index <= end; index++) {
                    if (str.charAt(index) == 'H') {
                        str = str.substring(0, index) + "X" + str.substring(index + 1);
                        str = str.substring(0, i) + "X" + str.substring(i + 1);
                        ans++;
                        break;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}