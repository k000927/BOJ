import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String ans = br.readLine();
        for (int i = 0; i < n - 1; i++) {
            StringBuilder sb = new StringBuilder(ans);
            String st = br.readLine();
            for (int j = 0; j < st.length(); j++) {
                if (ans.charAt(j) != st.charAt(j)) {
                    sb.setCharAt(j, '?');
                }
            }
            ans = sb.toString();
        }

        System.out.println(ans);
    }
}