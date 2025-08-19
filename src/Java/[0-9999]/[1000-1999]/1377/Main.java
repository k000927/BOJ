import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    static Node[] arr;

    static class Node implements Comparable<Node> {
        int num, index;

        Node(int num, int index) {
            this.num = num;
            this.index = index;
        }

        @Override
        public int compareTo(Node n) {
            return Integer.compare(this.num, n.num);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new Node[N];

        for (int i = 0; i < N; i++) {
            arr[i] = new Node(Integer.parseInt(br.readLine()), i);
        }

        Arrays.sort(arr);

        int ans = 0;
        for (int i = 0; i <N; i++) {
            ans = Math.max(arr[i].index - i + 1, ans);
        }

        System.out.println(ans);
    }
}