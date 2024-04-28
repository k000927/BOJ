import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (a == 0 || b == 0 || c == 0) break;
            if (Math.max(a, Math.max(b, c)) >= a + b + c - Math.max(a, Math.max(b, c))) System.out.println("Invalid");
            else if (a == b && a == c) System.out.println("Equilateral");
            else if (a != b && a != c && b != c) System.out.println("Scalene");
            else System.out.println("Isosceles");
        }
    }
}