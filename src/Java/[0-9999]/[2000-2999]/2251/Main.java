import java.io.*;
import java.util.*;

public class Main {
    static boolean[][][] visited;
    static boolean[] cVisited;
    static Queue<Integer> ans;
    static Queue<Bottle> queue;

    static class Bottle {
        int A, B, C;

        Bottle(int A, int B, int C) {
            this.A = A;
            this.B = B;
            this.C = C;
        }
    }

    static void moveWater(int A, int B, int C) {
        if (!visited[A][B][C]) {
            visited[A][B][C] = true;
            if (!cVisited[C]) {
                if (A == 0) {
                    ans.add(C);
                    cVisited[C] = true;
                }
            }
            queue.add(new Bottle(A, B, C));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        visited = new boolean[A + 1][B + 1][C + 1];
        cVisited = new boolean[C + 1];
        visited[A][B][C] = true;


        queue = new LinkedList<>();
        ans = new PriorityQueue<>();
        queue.add(new Bottle(0, 0, C));
        cVisited[C] = true;
        ans.add(C);

        Bottle b;
        while (!queue.isEmpty()) {
            b = queue.poll();

            // A -> B
            if (b.A + b.B > B) {
                moveWater((b.A + b.B) - B, B, b.C);
            } else {
                moveWater(0, b.A + b.B, b.C);
            }
            // A -> C
            if (b.A + b.C > C) {
                moveWater((b.A + b.C) - C, b.B, C);
            } else {
                moveWater(0, b.B, b.A + b.C);
            }
            // B -> A
            if (b.B + b.A > A) {
                moveWater(A, (b.A + b.B) - A, b.C);
            } else {
                moveWater(b.A + b.B, 0, b.C);
            }
            // B -> C
            if (b.B + b.C > C) {
                moveWater(b.A, (b.B + b.C) - C, C);
            } else {
                moveWater(b.A, 0, b.B + b.C);
            }
            // C -> A
            if (b.C + b.A > A) {
                moveWater(A, b.B, (b.C + b.A) - A);
            } else {
                moveWater(b.A + b.C, b.B, 0);
            }
            // C -> B
            if (b.C + b.B > B) {
                moveWater(b.A, B, (b.C + b.B) - B);
            } else {
                moveWater(b.A, b.B + b.C, 0);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!ans.isEmpty()) {
            sb.append(ans.poll()).append(' ');
        }

        System.out.println(sb);
    }
}