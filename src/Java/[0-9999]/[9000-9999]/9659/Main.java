import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());

        if (N % 2 == 1) System.out.println("SK");
        else System.out.println("CY");
    }
}