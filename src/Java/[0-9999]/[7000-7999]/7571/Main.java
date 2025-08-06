import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, x, y;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        List<Integer> xList = new ArrayList<>();
        List<Integer> yList = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            xList.add(x);
            yList.add(y);
        }

        Collections.sort(xList);
        Collections.sort(yList);

        int mid = M / 2;
        int midX = xList.get(mid);
        int midY = yList.get(mid);

        int ans = 0;
        for (int i = 0; i < M; i++) {
            ans += Math.abs(midX - xList.get(i));
            ans += Math.abs(midY - yList.get(i));
        }

        System.out.println(ans);
    }
}
