import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String word = br.readLine();
        int[] alpha = new int[26];
        Arrays.fill(alpha, 0);
        for (int i = 0; i < word.length(); i++) {
            alpha[(int) word.charAt(i) - 65]++;
        }
        int ans = 0;
        for (int i = 1; i < n; i++) {
            String temp = br.readLine();
            int[] temp_alpha = new int[26];

            int in_word = 0;
            int in_temp_word = 0;
            Arrays.fill(temp_alpha, 0);
            for (int j = 0; j < temp.length(); j++) {
                temp_alpha[(int) temp.charAt(j) - 65]++;
            }
            for (int j = 0; j < 26; j++) {
                if (alpha[j] == temp_alpha[j]) continue;
                else{
                    if(alpha[j] > temp_alpha[j]) in_word += alpha[j] - temp_alpha[j];
                    else in_temp_word += temp_alpha[j] - alpha[j];
                }
            }
            if (in_word <= 1 && in_temp_word <= 1) {
                ans++;
            }
        }
        System.out.println(ans);
    }
}