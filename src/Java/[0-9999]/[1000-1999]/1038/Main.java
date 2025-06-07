import java.io.*;
import java.util.*;

public class Main {
    static List<Long> numList;

    static void combination(int targetLength, int curLength, long lastNum, long num) {
        if (targetLength == curLength) {
            numList.add(num);
            return;
        }

        for (long i = 0; i < lastNum; i++) {
            combination(targetLength, curLength + 1, i, num * 10L + i);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        numList = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            combination(i, 0, 10L, 0);
        }

        int N = Integer.parseInt(br.readLine());

        if (N >=numList.size()) System.out.println(-1);
        else System.out.println(numList.get(N));
    }
}