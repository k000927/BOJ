import java.io.*;
import java.util.*;

public class Main {
    static String[][] maze;
    static int[][] fire;
    static Boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static class Node {
        int x;
        int y;
        int time;

        Node(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        maze = new String[r][c];
        fire = new int[r][c];
        visited = new Boolean[r][c];

        for (int i = 0; i < r; i++) {
            Arrays.fill(fire[i], -1);
            Arrays.fill(visited[i], false);
        }

        ArrayList<Node> firePlace = new ArrayList<>();
        ArrayList<Node> queue = new ArrayList<>();

        for (int i = 0; i < r; i++) {
            maze[i] = br.readLine().split("");
            for (int j = 0; j < c; j++) {
                if (maze[i][j].equals("F")) {
                    fire[i][j] = 0;
                    firePlace.add(new Node(i, j, 0));
                } else if (maze[i][j].equals("J")) queue.add(new Node(i, j, 0));
            }
        }

        while (!firePlace.isEmpty()) {
            Node curNode = firePlace.remove(0);
            int next_time = curNode.time + 1;

            for (int i = 0; i < 4; i++) {
                int next_x = curNode.x + dx[i];
                int next_y = curNode.y + dy[i];

                if (next_x < 0 || next_x >= r || next_y < 0 || next_y >= c) continue;
                if (maze[next_x][next_y].equals("#")) continue;
                if (fire[next_x][next_y] != -1) continue;

                fire[next_x][next_y] = next_time;
                firePlace.add(new Node(next_x, next_y, next_time));
            }
        }

        while (!queue.isEmpty()) {
            Node curNode = queue.remove(0);
            int next_time = curNode.time + 1;

            for (int i = 0; i < 4; i++) {
                int next_x = curNode.x + dx[i];
                int next_y = curNode.y + dy[i];

                if (next_x < 0 || next_x >= r || next_y < 0 || next_y >= c) {
                    System.out.println(next_time);
                    System.exit(0);
                }
                if (maze[next_x][next_y].equals("#")) continue;
                if (fire[next_x][next_y] != -1 && fire[next_x][next_y] <= next_time) continue;
                if (visited[next_x][next_y]) continue;

                queue.add(new Node(next_x, next_y, next_time));
                visited[next_x][next_y] = true;
            }
        }

        System.out.println("IMPOSSIBLE");
    }
}
