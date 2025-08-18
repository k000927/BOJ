import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[] num, tree;

    static void segTree(int node, int left, int right) {
        if (left == right) {
            tree[node] = num[left];
        } else {
            segTree(node * 2, left, (left + right) / 2);
            segTree(node * 2 + 1, (left + right) / 2 + 1, right);

            tree[node] = tree[node * 2] * tree[node * 2 + 1];
        }
    }

    static int getTree(int node, int left, int right, int start, int end) {
        if (end < left || right < start) {
            return 1;
        }

        if (start <= left && right <= end) {
            return tree[node];
        }

        int lValue = getTree(node * 2, left, (left + right) / 2, start, end);
        int rValue = getTree(node * 2 + 1, (left + right) / 2 + 1, right, start, end);
        return lValue * rValue;
    }

    static void updateValue(int node, int left, int right, int index, int value) {
        if (index < left || right < index) {
            return;
        }

        if (left == right) {
            num[index] = value;
            tree[node] = num[index];
            return;
        }

        updateValue(node * 2, left, (left + right) / 2, index, value);
        updateValue(node * 2 + 1, (left + right) / 2 + 1, right, index, value);
        tree[node] = tree[node * 2] * tree[node * 2 + 1];
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            String line = br.readLine();
            if (line == null || line.trim().isEmpty()) {
                break;
            }

            st = new StringTokenizer(line);

            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            num = new int[N + 1];
            tree = new int[N * 4];


            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                int temp = Integer.parseInt(st.nextToken());
                num[i] = temp == 0 ? 0 : temp / Math.abs(temp);
            }

            segTree(1, 1, N);

            String op;
            int a, b;
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());

                op = st.nextToken();
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());

                if (op.equals("C")) {
                    if (b != 0) b = b / Math.abs(b);
                    updateValue(1, 1, N, a, b);
                } else {
                    int res = getTree(1, 1, N, a, b);
                    if (res == 0) sb.append('0');
                    else if (res == 1) sb.append('+');
                    else sb.append('-');
                }
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }
}