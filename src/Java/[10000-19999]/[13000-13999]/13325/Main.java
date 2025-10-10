import java.io.*;
import java.util.*;

public class Main {
    static int N, sum;
    static int[] tree;
    static StreamTokenizer st;

    static void get(int index) {
        sum += tree[index];
        int left = index << 1;
        int right = left | 1;

        if (left >= N) {
            return;
        }

        get(left);
        get(right);

        int temp;
        if (tree[left] < tree[right]) {
            temp = tree[right] - tree[left];
            tree[left] = tree[right];
        } else {
            temp = tree[left] - tree[right];
            tree[right] = tree[left];
        }
        tree[index] += tree[left];
        sum += temp;
    }

    public static void main(String[] args) throws IOException {
        st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

        N = 1 << (nextInt() + 1);
        tree = new int[N + 1];

        for (int i = 2; i < N; i++) {
            tree[i] = nextInt();
        }

        get(1);
        System.out.println(sum);
    }

    private static int nextInt() throws IOException {
        st.nextToken();
        return (int) st.nval;
    }
}