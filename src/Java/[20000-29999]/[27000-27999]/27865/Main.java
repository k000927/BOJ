import java.io.*;
import java.util.*;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();

        while (true) {
            System.out.println("? 1");
            System.out.flush();

            String answer = scanner.next();

            if (answer.equals("Y")) {
                System.out.println("! 1");
                System.out.flush();
                break;
            }
        }
    }
}