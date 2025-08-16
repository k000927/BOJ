import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] num, tree;

    static void segTree(int node, int left, int right) {
        if (left == right) {
            tree[node] = num[left];
        } else {
            segTree(node * 2, left, (left + right) / 2);
            segTree(node * 2 + 1, (left + right) / 2 + 1, right);
            tree[node] = Math.min(tree[node * 2], tree[node * 2 + 1]);
        }
    }

    static void updateTree(int node, int left, int right, int index, int value) {
        if (right < index || index < left) {
            return;
        }

        if (left == right) {
            tree[node] = value;
            num[index] = value;
            return;
        }

        updateTree(node * 2, left, (left + right) / 2, index, value);
        updateTree(node * 2 + 1, (left + right) / 2 + 1, right, index, value);
        tree[node] = Math.min(tree[node * 2], tree[node * 2 + 1]);
    }

    static int getTree(int node, int left, int right, int start, int end) {
        if (end < left || right < start) {
            return Integer.MAX_VALUE;
        }

        if (start <= left && right <= end) {
            return tree[node];
        }

        int lValue = getTree(node * 2, left, (left + right) / 2, start, end);
        int rValue = getTree(node * 2 + 1, (left + right) / 2 + 1, right, start, end);

        return Math.min(lValue, rValue);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        num = new int[N + 1];
        tree = new int[N * 4];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        segTree(1, 1, N);

        int a, b, c;

        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            if (a == 1) {
                updateTree(1, 1, N, b, c);
            } else {
                sb.append(getTree(1, 1, N, b, c)).append("\n");
            }
        }

        System.out.print(sb);
    }
}