import java.io.*;
import java.util.*;

public class Main {
    static int A, B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        System.out.println(((A & 1) == 0 || (B & 1) == 0) ? 'A' : 'B');
    }
}