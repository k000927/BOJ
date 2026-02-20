import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        int prev = -1;
        int[] block = {0, 0};

        for (int i = 0; i < input.length(); i++) {
            int cur = input.charAt(i) - '0';

            if(cur != prev) block[cur]++;
            prev = cur;
        }

        System.out.println(Math.min(block[0], block[1]));
    }
}