import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        if(T%10 != 0) sb.append("-1");
        else {
            sb.append(T/300).append(' ');
            T -= T/300 * 300;

            sb.append(T/60).append(' ');
            T -= T/60 * 60;

            sb.append(T/10);
        }

        System.out.println(sb);
    }
}