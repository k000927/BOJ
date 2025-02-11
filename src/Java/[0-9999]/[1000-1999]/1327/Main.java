import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int n;
    static int k;
    static StringTokenizer st;

    static class NumWithCount {
        String num;
        int cnt;

        NumWithCount(String num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
    }

    static String reverseString(String num, int index) {
        StringBuilder sb = new StringBuilder();

        sb.append(num.substring(0, index));
        StringBuilder preReverse = new StringBuilder(num.substring(index, index + k));
        sb.append(preReverse.reverse());
        sb.append(num.substring(index + k));

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<String> visitedNum = new HashSet<>();
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            sb.append(i);
        }

        String orderedNum = sb.toString();

        String startString = br.readLine().replaceAll(" ", "");

        List<NumWithCount> numQueue = new ArrayList<>();
        numQueue.add(new NumWithCount(startString, 0));
        visitedNum.add(startString);

        while (!numQueue.isEmpty()) {
            NumWithCount numWithCount = numQueue.remove(0);
            String curNum = numWithCount.num;

            if (orderedNum.equals(curNum)) {
                System.out.println(numWithCount.cnt);
                System.exit(0);
            }

            for (int i = 0; i <= n - k; i++) {
                String nextString = reverseString(curNum, i);

                if (visitedNum.contains(nextString)) continue;

                visitedNum.add(nextString);
                numQueue.add(new NumWithCount(nextString, numWithCount.cnt + 1));
            }
        }

        System.out.println(-1);
    }
}