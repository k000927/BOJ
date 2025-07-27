import java.io.*;

public class Main {
    static int N;

    static char getMoo(int k) {
        int size = 3, i = 0;
        if (k == 1) return 'm';
        else if (k <= 3) return 'o';
        else {
            while (size < k) {
                size = size * 2 + i++ + 4;
            }

            int temp = (size - i - 3) / 2;
            if (size - temp + 1 <= k) {
                return getMoo(k - size + temp);
            } else if (k == temp + 1)
                return 'm';
            else
                return 'o';
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(getMoo(Integer.parseInt(br.readLine())));
    }
}