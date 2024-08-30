import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static String getString(String originalWord) {
        int[] alpha = new int[26];
        Arrays.fill(alpha, 0);

        for (int i = 0; i < originalWord.length(); i++) {
            alpha[originalWord.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            sb.append(alpha[i]);
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> ans = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String str = getString(br.readLine());

            if (!ans.contains(str)) {
                ans.add(str);
            }
        }

        System.out.println(ans.size());
    }
}
