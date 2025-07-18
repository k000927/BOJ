import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String regex = "(100+1+|01)+";

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            if(br.readLine().matches(regex))
                sb.append('Y').append('E').append('S').append('\n');
            else
                sb.append('N').append('O').append('\n');
        }

        System.out.println(sb);
    }
}