import java.io.*;
import java.util.*;

public class Main {
    static int t;
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static void solve(int caseNum) throws IOException {
        int[] numbers = new int[10];

        String phone = br.readLine();
        numbers[0] = Math.toIntExact(phone.chars().filter(c -> c == 'Z').count());
        numbers[2] = Math.toIntExact(phone.chars().filter(c -> c == 'W').count());
        numbers[4] = Math.toIntExact(phone.chars().filter(c -> c == 'U').count());
        numbers[6] = Math.toIntExact(phone.chars().filter(c -> c == 'X').count());
        numbers[8] = Math.toIntExact(phone.chars().filter(c -> c == 'G').count());
        numbers[1] = Math.toIntExact(phone.chars().filter(c -> c == 'O').count()) - numbers[0] - numbers[2] - numbers[4];
        numbers[3] = Math.toIntExact(phone.chars().filter(c -> c == 'H').count()) - numbers[8];
        numbers[5] = Math.toIntExact(phone.chars().filter(c -> c == 'F').count()) - numbers[4];
        numbers[7] = Math.toIntExact(phone.chars().filter(c -> c == 'V').count()) - numbers[5];
        numbers[9] = Math.toIntExact(phone.chars().filter(c -> c == 'I').count()) - numbers[5] - numbers[6] - numbers[8];

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(String.valueOf(i).repeat(numbers[i]));
        }
        System.out.printf("Case #%d: %s\n", caseNum, sb);
    }

    public static void main(String[] args) throws IOException {
        t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            solve(i + 1);
        }
    }
}