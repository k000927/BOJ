import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int T, W;
    static int[][][] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        tree = new int[3][T + 1][W + 1];

        int plumTree = Integer.parseInt(br.readLine());
        int notPlumTree;
        if (plumTree == 1)
            tree[plumTree][1][0] = 1;
        else
            tree[plumTree][1][1] = 1;

        int ans = 1;
        for (int t = 2; t <= T; t++) {
            plumTree = Integer.parseInt(br.readLine());
            notPlumTree = plumTree % 2 + 1;

            tree[plumTree][t][0] = tree[plumTree][t - 1][0] + 1;
            tree[notPlumTree][t][0] = tree[notPlumTree][t - 1][0];
            ans = Math.max(ans, tree[plumTree][t][0]);
            ans = Math.max(ans, tree[notPlumTree][t][0]);
            for (int w = 1; w <= W; w++) {
                tree[plumTree][t][w] = Math.max(tree[plumTree][t - 1][w], tree[notPlumTree][t - 1][w - 1]) + 1;
                tree[notPlumTree][t][w] = Math.max(tree[plumTree][t - 1][w - 1], tree[notPlumTree][t - 1][w]);
                ans = Math.max(ans, tree[plumTree][t][w]);
                ans = Math.max(ans, tree[notPlumTree][t][w]);

            }
        }

        System.out.println(ans);
    }
}
