import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());


        for (int i = 0; i < n; i++) {
            String[] presidents = br.readLine().split(" ");

            int ans = 0;
            for (String president : presidents) {
                switch (president) {
                    case "Franklin" -> ans += 100;
                    case "Grant" -> ans += 50;
                    case "Jackson" -> ans += 20;
                    case "Hamilton" -> ans += 10;
                    case "Lincoln" -> ans += 5;
                    case "Washington" -> ans += 1;
                }
            }

            System.out.println("$" + ans);
        }
    }
}