import java.io.*;

public class Main {
    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            ans.append(br.readLine().endsWith("0") ? 1 : 0).append('\n');
        }

        System.out.println(ans);
    }
}