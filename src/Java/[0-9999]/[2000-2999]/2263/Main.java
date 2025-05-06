import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] inorder;
    static int[] postorder;
    static StringBuilder ans = new StringBuilder();

    static void setTree(int inFirst, int inLast, int postFirst, int postLast, int rootIndex, int treeIndex) {

        if (inFirst == inLast) {
            ans.append(inorder[inFirst]).append(" ");
            return;
        }

        if (inFirst > inLast) return;

        int rootNum = postorder[rootIndex];
        ans.append(postorder[rootIndex]).append(" ");

        int temp = inFirst;
        while (inorder[temp] != rootNum) temp++;

        setTree(inFirst, temp - 1, postFirst, postFirst + (temp - 1 - inFirst), postFirst + (temp - 1 - inFirst), treeIndex * 2);
        setTree(temp + 1, inLast, postFirst + (temp - 1 - inFirst) + 1, postLast - 1, postLast - 1, treeIndex * 2 + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        inorder = new int[N];
        postorder = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            inorder[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            postorder[i] = Integer.parseInt(st.nextToken());
        }

        setTree(0, N - 1, 0, N - 1, N - 1, 1);
        System.out.println(ans);
    }
}