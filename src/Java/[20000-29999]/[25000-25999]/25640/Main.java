import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String myMBTI= br.readLine();

        int n = Integer.parseInt(br.readLine());

        int ans = 0;
        for (int i = 0; i < n; i++) {
            String MBTI = br.readLine();
            if (myMBTI.equals(MBTI)) ans++;
        }

        System.out.println(ans);
    }
}
