import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int r;
    static int[][] domino;
    static boolean[][] ForS;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int ans = 0;

    static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void printAns(){
        System.out.println(ans);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (ForS[i][j]) {
                    System.out.print("S ");
                } else System.out.print("F ");
            }
            System.out.println();
        }
    }

    static void pushDomino(int x, int y, String d) {
        ArrayDeque<Node> dominoDeque = new ArrayDeque<>();
        dominoDeque.push(new Node(x, y));
        int dir = switch (d) {
            case "E" -> 0;
            case "W" -> 1;
            case "S" -> 2;
            default -> 3;
        };

        while (!dominoDeque.isEmpty()) {
            Node node = dominoDeque.pop();
            int k = domino[node.x][node.y];

            for (int i = 0; i < k; i++) {
                int nextX = node.x + dx[dir] * i;
                int nextY = node.y + dy[dir] * i;
                if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) break;
                if (!ForS[nextX][nextY]) continue;

                ForS[nextX][nextY] = false;
                ans++;
                dominoDeque.push(new Node(nextX, nextY));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        domino = new int[n][m];
        ForS = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(ForS[i], true);
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                domino[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            String d = st.nextToken();
            pushDomino(x, y, d);

            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken()) - 1;
            int q = Integer.parseInt(st.nextToken()) - 1;

            ForS[p][q] = true;
        }

        printAns();
    }
}