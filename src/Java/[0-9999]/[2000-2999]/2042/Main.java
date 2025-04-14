import java.io.*;
import java.util.*;

/*
 * 세그먼트 트리를 이용한 풀이
 */
public class Main {
    static int N;
    static int M;
    static int K;
    static long[] num;
    static long[] tree;
    static final StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    static void segTree(int node, int start, int end) {
        if (start == end) {
            tree[node] = num[start];
        } else {
            segTree(node << 1, start, (start + end) >> 1);
            segTree((node << 1) + 1, ((start + end) >> 1) + 1, end);
            tree[node] = tree[node << 1] + tree[(node << 1) + 1];
        }
    }

    static void updateSeg(int node, int start, int end, int index, long val) {
        if (index < start || index > end) {
            return;
        }

        if (start == end) {
            num[index] = val;
            tree[node] = val;
            return;
        }

        updateSeg(node << 1, start, (start + end) >> 1, index, val);
        updateSeg((node << 1) + 1, ((start + end) >> 1) + 1, end, index, val);
        tree[node] = tree[node << 1] + tree[(node << 1) + 1];
    }

    static long getSeg(int node, int start, int end, int left, int right) {
        if (left > end || right < start) return 0L;
        if (left <= start && end <= right) {
            return tree[node];
        }
        long lSum = getSeg(node << 1, start, (start + end) >> 1, left, right);
        long rSum = getSeg((node << 1) + 1, ((start + end) >> 1) + 1, end, left, right);
        return lSum + rSum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        num = new long[N + 1];
        tree = new long[N * 4];

        for (int i = 1; i <= N; i++) {
            num[i] = Long.parseLong(br.readLine());
        }

        segTree(1, 1, N);

        long a;
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            a = Long.parseLong(st.nextToken());

            if (a == 1) updateSeg(1, 1, N, Integer.parseInt(st.nextToken()), Long.parseLong(st.nextToken()));
            else
                ans.append(getSeg(1, 1, N, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()))).append("\n");
        }

        System.out.println(ans);
    }
}