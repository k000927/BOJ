import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        Boolean[] ans = new Boolean[s.length()];
        Arrays.fill(ans, false);

        int num_of_zero = 0;
        int num_of_one = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') num_of_zero++;
            else num_of_one++;
        }

        num_of_zero /= 2;
        num_of_one /= 2;

        for (int i = 0; num_of_zero > 0; i++) {
            if (s.charAt(i) == '0') {
                ans[i] = true;
                num_of_zero--;
            }
        }

        for (int i = s.length() - 1; num_of_one > 0; i--) {
            if (s.charAt(i) == '1'){
                ans[i] = true;
                num_of_one--;
            }
        }

        for (int i = 0; i < s.length(); i++) {
            if(ans[i]) bw.write(s.charAt(i));
        }

        bw.flush();
    }
}