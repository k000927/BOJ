import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] dice;

    static int getMaxOne() {
        int max = dice[0];

        max = Math.max(max, dice[1]);
        max = Math.max(max, dice[2]);
        max = Math.max(max, dice[3]);
        max = Math.max(max, dice[4]);
        max = Math.max(max, dice[5]);

        return max;
    }

    static int getMinOne() {
        int min = dice[0];

        min = Math.min(min, dice[1]);
        min = Math.min(min, dice[2]);
        min = Math.min(min, dice[3]);
        min = Math.min(min, dice[4]);
        min = Math.min(min, dice[5]);

        return min;
    }

    static int getMinTwo() {
        int min = Integer.MAX_VALUE;

        min = Math.min(min, dice[0] + dice[1]);
        min = Math.min(min, dice[0] + dice[2]);
        min = Math.min(min, dice[0] + dice[3]);
        min = Math.min(min, dice[0] + dice[4]);
        min = Math.min(min, dice[1] + dice[2]);
        min = Math.min(min, dice[1] + dice[3]);
        min = Math.min(min, dice[1] + dice[5]);
        min = Math.min(min, dice[2] + dice[4]);
        min = Math.min(min, dice[2] + dice[5]);
        min = Math.min(min, dice[3] + dice[4]);
        min = Math.min(min, dice[3] + dice[5]);
        min = Math.min(min, dice[4] + dice[5]);

        return min;
    }

    static int getMinThree() {
        int min = Integer.MAX_VALUE;

        min = Math.min(min, dice[0] + dice[1] + dice[2]);
        min = Math.min(min, dice[0] + dice[1] + dice[3]);
        min = Math.min(min, dice[0] + dice[2] + dice[4]);
        min = Math.min(min, dice[0] + dice[3] + dice[4]);
        min = Math.min(min, dice[1] + dice[2] + dice[5]);
        min = Math.min(min, dice[1] + dice[3] + dice[5]);
        min = Math.min(min, dice[2] + dice[4] + dice[5]);
        min = Math.min(min, dice[3] + dice[4] + dice[5]);

        return min;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        dice = new int[6];
        for (int i = 0; i < 6; i++) {
            dice[i] = Integer.parseInt(st.nextToken());
        }

        int maxOne = getMaxOne();
        int minOne = getMinOne();
        int minTwo = getMinTwo();
        int minThree = getMinThree();

        long ans = 0;
        if (N == 1)
            ans = dice[0] + dice[1] + dice[2] + dice[3] + dice[4] + dice[5] - maxOne;
        else
            ans = (long) (N - 2) * (N - 1) * minOne * 4 + (long) (N - 1) * minTwo * 4 + (long) (N - 2) * (N - 2) * minOne + (long) (N - 2) * minTwo * 4 + minThree * 4L;

        System.out.println(ans);
    }
}
