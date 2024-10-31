import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static Piece[][] puzzle;
    static StringTokenizer st;
    static int idx = 1;
    static Queue<Piece> pq = new ArrayDeque<>();

    static class Piece {
        int x;
        int y;
        int num;
        int inDegree;
        ArrayList<Piece> adj;

        public Piece(int x, int y) {
            this.x = x;
            this.y = y;
            this.num = 0;
            this.adj = new ArrayList<>();
            this.inDegree = 0;
        }
    }

    static void print() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                bw.write(puzzle[i][j].num + " ");
            }
            bw.write("\n");
        }

        bw.flush();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        puzzle = new Piece[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                puzzle[i][j] = new Piece(i, j);
            }
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n - 1; j++) {
                String inEq = st.nextToken();
                if (inEq.equals(">")) {
                    puzzle[i][j].inDegree++;
                    puzzle[i][j + 1].adj.add(puzzle[i][j]);
                } else {
                    puzzle[i][j + 1].inDegree++;
                    puzzle[i][j].adj.add(puzzle[i][j + 1]);
                }
            }
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                String inEq = st.nextToken();
                if (inEq.equals(">")) {
                    puzzle[i][j].inDegree++;
                    puzzle[i + 1][j].adj.add(puzzle[i][j]);
                } else {
                    puzzle[i + 1][j].inDegree++;
                    puzzle[i][j].adj.add(puzzle[i + 1][j]);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (puzzle[i][j].inDegree == 0)
                    pq.add(puzzle[i][j]);
            }
        }

        topologySort();
        print();
    }

    static void topologySort() {
        while (!pq.isEmpty()) {
            Piece curr = pq.poll();
            curr.num = idx++;
            for (Piece piece : curr.adj) {
                piece.inDegree--;
                if (piece.inDegree == 0) {
                    pq.add(piece);
                }
            }
        }
    }
}