import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());


        while (N-- > 0) {
            String st = br.readLine();


            boolean[] alpha = new boolean[26];
            for (int i = 0; i < st.length(); i++) {
                char c = st.charAt(i);

                if ('a' <= c && c <= 'z')
                    alpha[c - 'a'] = true;

                if ('A' <= c && c <= 'Z')
                    alpha[c - 'A'] = true;
            }

            int cnt = 0;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if (alpha[i])
                    cnt++;
                else
                    sb.append((char) ('a' + i));
            }

            if (cnt == 26)
                System.out.println("pangram");
            else
                System.out.println("missing " + sb.toString());
        }
    }
}