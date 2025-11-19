import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());

        if(N == 1) System.out.println("SK");
        else if(N == 2) System.out.println("CY");
        else {
            int flag = (int) ((N-3) % 7L);
            if(flag == 4 || flag == 6)
                System.out.println("CY");
            else
                System.out.println("SK");
        }
    }
}