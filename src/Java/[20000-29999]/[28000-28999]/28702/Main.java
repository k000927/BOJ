import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int ans;
        String first = br.readLine();
        String second = br.readLine();
        String third = br.readLine();

        if (first.charAt(0) >= 48 && first.charAt(0) <= 57) {
            ans = Integer.parseInt(first) + 3;
        } else if (second.charAt(0) >= 48 && second.charAt(0) <= 57) {
            ans = Integer.parseInt(second) + 2;
        } else {
            ans = Integer.parseInt(third) + 1;
        }

        if (ans % 3 == 0 && ans % 5 == 0) System.out.println("FizzBuzz");
        else if (ans % 3 == 0 && ans % 5 != 0) System.out.println("Fizz");
        else if (ans % 3 != 0 && ans % 5 == 0) System.out.println("Buzz");
        else System.out.println(ans);
    }
}