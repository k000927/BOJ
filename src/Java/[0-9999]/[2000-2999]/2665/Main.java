import java.io.*;
import java.util.*;

// 흰 방들의 섬을 구분
// 각 흰 방들의 거리를 구해 다익스트라

public class Main {
    static int n;
    static int roomNum = 0;
    static int[][] room;
    static boolean[][] visited;
    static int[][] dist;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static class Pos {
        int x;
        int y;
        int dist;

        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }

        Pos(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

    }

    static void groupingRoom(int i, int j) {
        ArrayList<Pos> list = new ArrayList<>();
        list.add(new Pos(i, j));

        room[i][j] = ++roomNum;
        visited[i][j] = true;

        while (!list.isEmpty()) {
            Pos curPos = list.remove(0);

            for (int k = 0; k < 4; k++) {
                int nx = curPos.x + dx[k];
                int ny = curPos.y + dy[k];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n || visited[nx][ny] || room[nx][ny] == 0)
                    continue;

                room[nx][ny] = roomNum;
                visited[nx][ny] = true;
                list.add(new Pos(nx, ny));
            }
        }
    }

    static void getDist(int i, int j) {
        visited = new boolean[n][n];

        ArrayList<Pos> list = new ArrayList<>();
        list.add(new Pos(i, j, 0));
        visited[i][j] = true;

        while (!list.isEmpty()) {
            Pos curPos = list.remove(0);

            for (int k = 0; k < 4; k++) {
                int nx = curPos.x + dx[k];
                int ny = curPos.y + dy[k];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n || visited[nx][ny]
                        || room[nx][ny] == room[i][j])
                    continue;

                if (room[nx][ny] != 0) {
                    if (dist[room[i][j]][room[nx][ny]] <= curPos.dist)
                        continue;
                    else {
                        dist[room[i][j]][room[nx][ny]] = curPos.dist;
                        dist[room[nx][ny]][room[i][j]] = curPos.dist;
                    }
                }


                visited[nx][ny] = true;
                list.add(new Pos(nx, ny, curPos.dist + 1));
            }
        }

    }

    static int getNextNode(int[] d, boolean[] visited) {
        int nextNode = 0;
        for (int i = 2; i <= roomNum; i++) {
            if (d[nextNode] > d[i] && !visited[i]) {
                nextNode = i;
            }
        }

        return nextNode;
    }

    static int dijkstra() {
        int end = room[n - 1][n - 1];

        int[] d = new int[roomNum + 1];
        boolean[] visited = new boolean[roomNum + 1];

        d[0] = 1000;
        for (int i = 1; i <= roomNum; i++)
            d[i] = dist[1][i];

        int node = 0;
        while ((node = getNextNode(d, visited)) != 0) {
            visited[node] = true;

            for (int i = 2; i <= roomNum; i++) {
                if (visited[i])
                    continue;
                d[i] = Math.min(d[node] + dist[node][i], d[i]);
            }
        }
        return d[end];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        room = new int[n][n];
        visited = new boolean[n][n];


        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                room[i][j] = line.charAt(j) - '0';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (room[i][j] == 1 && !visited[i][j]) {
                    groupingRoom(i, j);
                }
            }
        }

        dist = new int[roomNum + 1][roomNum + 1];
        for (int i = 0; i <= roomNum; i++) {
            Arrays.fill(dist[i], 1000);
            dist[i][i] = 0;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (room[i][j] != 0) {
                    getDist(i, j);
                }
            }
        }

        System.out.println(dijkstra());
    }
}
