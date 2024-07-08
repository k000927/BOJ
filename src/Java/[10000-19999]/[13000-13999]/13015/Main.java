import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());


        StringBuilder ans = new StringBuilder();

        StringBuilder str1 = new StringBuilder();
        str1.append("*".repeat(n));
        String stars = str1.toString();

        StringBuilder str2 = new StringBuilder();
        str2.append("*");
        str2.append(" ".repeat(n - 2));
        str2.append("*");
        String starsWithSpace = str2.toString();

        ans.append(stars);
        ans.append(" ".repeat(n * 2 - 3));
        ans.append(stars);
        ans.append("\n");

        for (int i = n - 2; i > 0; i--) {
            ans.append(" ".repeat(n - i - 1));
            ans.append(starsWithSpace);
            ans.append(" ".repeat(i * 2 - 1));
            ans.append(starsWithSpace);
            ans.append("\n");
        }

        ans.append(" ".repeat(n - 1));
        ans.append("*");
        ans.append(" ".repeat(n - 2));
        ans.append("*");
        ans.append(" ".repeat(n - 2));
        ans.append("*");
        ans.append("\n");

        for (int i = 1; i < n - 1; i++) {
            ans.append(" ".repeat(n - i - 1));
            ans.append(starsWithSpace);
            ans.append(" ".repeat(i * 2 - 1));
            ans.append(starsWithSpace);
            ans.append("\n");
        }

        ans.append(stars);
        ans.append(" ".repeat(n * 2 - 3));
        ans.append(stars);

        System.out.println(ans.toString());
    }
}