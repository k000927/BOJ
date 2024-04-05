import java.io.*;
import java.util.*;

import static java.lang.Math.abs;
import static java.lang.Math.min;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long[][] points = new long[8][2];
        long[][] graph = new long[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                graph[i][j] = 10000000000L;
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        points[0][0] = Long.parseLong(st.nextToken());
        points[0][1] = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());
        points[1][0] = Long.parseLong(st.nextToken());
        points[1][1] = Long.parseLong(st.nextToken());

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            points[(i + 1) * 2][0] = Long.parseLong(st.nextToken());
            points[(i + 1) * 2][1] = Long.parseLong(st.nextToken());
            points[(i + 1) * 2 + 1][0] = Long.parseLong(st.nextToken());
            points[(i + 1) * 2 + 1][1] = Long.parseLong(st.nextToken());
            graph[(i + 1) * 2][(i + 1) * 2 + 1] = 10;
            graph[(i + 1) * 2 + 1][(i + 1) * 2] = 10;
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i == j) {
                    graph[i][j] = 0;
                }
                graph[i][j] = min(graph[i][j], (abs(points[i][0] - points[j][0]) + abs(points[i][1] - points[j][1])));
            }
        }

        for (int k = 0; k < 8; k++) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    graph[i][j] = min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }

        System.out.println(graph[0][1]);
    }
}