import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class City {
        int s, x, y;

        public City(int s, int x, int y) {
            this.s = s;
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        List<City> cityList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            cityList.add(new City(s, x, y));
        }

        int num_of_city = cityList.size();

        int[][] graph = new int[num_of_city][num_of_city];
        for (int i = 0; i < num_of_city; i++) {
            Arrays.fill(graph[i], 100000000);
        }

        for (int i = 0; i < num_of_city; i++) {
            for (int j = 0; j < num_of_city; j++) {
                if (i == j) {
                    graph[i][j] = 0;
                    continue;
                }
                int s1 = cityList.get(i).s;
                int x1 = cityList.get(i).x;
                int y1 = cityList.get(i).y;
                int s2 = cityList.get(j).s;
                int x2 = cityList.get(j).x;
                int y2 = cityList.get(j).y;
                if (s1 == 1 && s2 == 1) {
                    graph[i][j] = Math.min(t, Math.abs(x1 - x2) + Math.abs(y1 - y2));
                } else {
                    graph[i][j] = Math.abs(x1 - x2) + Math.abs(y1 - y2);
                }
            }
        }

        for (int i = 0; i < num_of_city; i++) {
            for (int j = 0; j < num_of_city; j++) {
                for (int k = 0; k < num_of_city; k++) {
                    graph[j][k] = Math.min(graph[j][k], graph[j][i] + graph[i][k]);
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            System.out.println(graph[a - 1][b - 1]);
        }
    }
}