import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, index, maxDepth;
    static Node[] nodeArr;
    static int[] min, max;
    static boolean[] isRoot;

    static class Node {
        Node left, right;

        Node() {
        }

        public void setLeft(int left) {
            if(left != -1){
                this.left = nodeArr[left];
                isRoot[left] = false;
            }
        }

        public void setRight(int right) {
            if(right != -1){
                this.right = nodeArr[right];
                isRoot[right] = false;
            }
        }
    }

    static void inOrder(Node curNode, int depth) {
        if (curNode.left != null) {
            inOrder(curNode.left, depth + 1);
        }

        min[depth] = Math.min(min[depth], index);
        max[depth] = Math.max(max[depth], index);
        index++;
        maxDepth = Math.max(maxDepth, depth);

        if (curNode.right != null) {
            inOrder(curNode.right, depth + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        nodeArr = new Node[N + 1];
        isRoot = new boolean[N + 1];
        min = new int[N + 1];
        max = new int[N + 1];

        Arrays.fill(min, Integer.MAX_VALUE);
        Arrays.fill(max, Integer.MIN_VALUE);
        Arrays.fill(isRoot, true);
        for (int i = 1; i <= N; i++) {
            nodeArr[i] = new Node();
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            nodeArr[num].setLeft(left);
            nodeArr[num].setRight(right);
        }

        int root = 0;
        for (int i = 1; i <= N; i++) {
            if(isRoot[i]){
                root = i;
                break;
            }
        }

        index = 1;
        inOrder(nodeArr[root], 1);

        int maxWidth = Integer.MIN_VALUE;
        int ansDepth = 0;

        for (int i = 1; i <= maxDepth; i++) {
            int curWidth = max[i] - min[i] + 1;
            if (curWidth > maxWidth) {
                maxWidth = curWidth;
                ansDepth = i;
            }
        }

        System.out.println(ansDepth + " " + maxWidth);
    }
}
