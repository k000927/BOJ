import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int count = 0;
        char prev = str.charAt(0);
        for (int i = 0; i < N; i++) {
            if (prev - str.charAt(i) == -1 || prev - str.charAt(i) == 1)
                count++;
            else
                count = 1;

            if (count == 5) {
                System.out.println("YES");
                System.exit(0);
            }

            prev = str.charAt(i);
        }

        System.out.println("NO");
    }
}