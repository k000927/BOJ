import java.io.*;

public class Main {
    static long N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Long.parseLong(br.readLine());

        if (N % 5 == 0 || N % 5 == 2) System.out.println("CY");
        else System.out.println("SK");
    }
}