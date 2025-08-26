import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static Node[] nodeArr;
    static int[] min;
    static int[] max;
    static int index;

    static class Node {
        Node left, right;

        Node() {
        }

        public void setLeft(int left) {
            this.left = left == -1 ? null : nodeArr[left];
        }

        public void setRight(int right) {
            this.right = right == -1 ? null : nodeArr[right];
        }
    }

    static void inOrder(Node curNode, int depth) {
        if (curNode.left != null) {
            inOrder(curNode.left, depth + 1);
        }

        min[depth] = Math.min(min[depth], index);
        max[depth] = Math.max(max[depth], index);
        index++;

        if (curNode.right != null) {
            inOrder(curNode.right, depth + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        nodeArr = new Node[N + 1];
        min = new int[N + 1];
        max = new int[N + 1];

        Arrays.fill(min, Integer.MAX_VALUE);
        Arrays.fill(max, Integer.MIN_VALUE);

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

        index = 1;
        inOrder(nodeArr[1], 1);

        System.out.println();
    }
}
