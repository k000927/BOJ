import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] num, tree;

    static void segTree(int node, int left, int right) {
        if (left == right) {
            tree[node] = left;
            return;
        }

        segTree(node * 2, left, (left + right) / 2);
        segTree(node * 2 + 1, (left + right) / 2 + 1, right);

        int leftV = tree[node * 2];
        int rightV = tree[node * 2 + 1];

        if (num[leftV] < num[rightV]) {
            tree[node] = leftV;
        } else if (num[leftV] > num[rightV]) {
            tree[node] = rightV;
        } else {
            tree[node] = Math.min(leftV, rightV);
        }
    }

    static void updateTree(int node, int left, int right, int index, int value) {
        if (index < left || right < index)
            return;

        if (left == right) {
            num[left] = value;
            tree[node] = left;
            return;
        }

        updateTree(node * 2, left, (left + right) / 2, index, value);
        updateTree(node * 2 + 1, (left + right) / 2 + 1, right, index, value);

        int leftV = tree[node * 2];
        int rightV = tree[node * 2 + 1];

        if (num[leftV] < num[rightV]) {
            tree[node] = leftV;
        } else if (num[leftV] > num[rightV]) {
            tree[node] = rightV;
        } else {
            tree[node] = Math.min(leftV, rightV);
        }
    }

    static int getTree(int node, int left, int right, int start, int end) {
        if (left > end || right < start) {
            return 0;
        } else if (start <= left && right <= end) {
            return tree[node];
        }

        int leftV = getTree(node * 2, left, (left + right) / 2, start, end);
        int rightV = getTree(node * 2 + 1, (left + right) / 2 + 1, right, start, end);


        if (num[leftV] < num[rightV]) {
            return leftV;
        } else if (num[leftV] > num[rightV]) {
            return rightV;
        } else {
            return Math.min(leftV, rightV);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        num = new int[N + 1];
        tree = new int[N * 4];
        num[0] = Integer.MAX_VALUE;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        segTree(1, 1, N);
        int op, a, b;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            op = Integer.parseInt(st.nextToken());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            if (op == 1) {
                updateTree(1, 1, N, a, b);
            } else {
                ans.append(getTree(1, 1, N, a, b)).append('\n');
            }
        }

        System.out.println(ans);
    }
}
