import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static char[][][] digits;
    static char[][][] inputs;

    static void init(String input) {
        digits = new char[10][5][3];

        String line = """
                ###...#.###.###.#.#.###.###.###.###.###
                #.#...#...#...#.#.#.#...#.....#.#.#.#.#
                #.#...#.###.###.###.###.###...#.###.###
                #.#...#.#.....#...#...#.#.#...#.#.#...#
                ###...#.###.###...#.###.###...#.###.###
                """;

        int index = 0;
        for (int j = 0; j < 5; j++) {
            for (int i = 0; i < 10; i++) {
                for (int k = 0; k < 3; k++) {
                    digits[i][j][k] = line.charAt(index++);
                }
                index++;
            }
        }

        inputs = new char[N][5][3];
        index = 0;
        for (int j = 0; j < 5; j++) {
            for (int i = 0; i < N; i++) {
                for (int k = 0; k < 3; k++) {
                    inputs[i][j][k] = input.charAt(index++);
                }
                index++;
            }
        }
    }

    static boolean able(int index, int digit) {
        for (int j = 0; j < 5; j++) {
            for (int k = 0; k < 3; k++) {
                if (digits[digit][j][k] == '.' && inputs[index][j][k] == '#') return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringBuilder input = new StringBuilder();

        for (int i = 0; i < 5; i++) {
            input.append(br.readLine()).append('\n');
        }

        init(input.toString());

        double ans = 0;
        Queue<Integer> ableDigit = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 10; j++) {
                if (able(i, j)) {
                    ableDigit.offer(j);
                }
            }

            if (ableDigit.isEmpty()) {
                System.out.println(-1);
                System.exit(0);
            }

            int count = ableDigit.size();
            while (!ableDigit.isEmpty()) {
                ans += Math.pow(10, N - i - 1) * ableDigit.poll() / count;
            }
        }

        System.out.println(ans);
    }
}