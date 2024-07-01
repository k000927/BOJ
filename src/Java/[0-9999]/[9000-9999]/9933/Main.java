import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        ArrayList<String> password_set = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String password = br.readLine();
            password_set.add(password);
            String reversedPassword = (new StringBuffer(password)).reverse().toString();

            if (password_set.contains(reversedPassword)) {
                System.out.println(password.length() + " " + password.charAt(password.length() / 2));
                break;
            }
        }
    }
}