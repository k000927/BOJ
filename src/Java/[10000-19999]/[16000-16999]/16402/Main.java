import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static Map<String, Integer> countryIndex;
    static Map<Integer, String> countryName;
    static int[] parent;

    static int find(int x) {
        if (parent[x] == x)
            return x;
        else
            return parent[x] = find(parent[x]);
    }

    static void union(int win, int lose) {
        // 승전국의 종주국
        int winParent = find(win);
        // 패전국의 종주국
        int loseParent = find(lose);

        // 종주국 공격에 성공한 경우
        if (winParent == lose) {
            parent[win] = win;
            parent[lose] = win;
        } else {
            parent[loseParent] = winParent;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parent = new int[N];

        countryIndex = new HashMap<>();
        countryName = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split(" ");

            String country = split[2];
            parent[i] = i;
            countryIndex.put(country, i);
            countryName.put(i, country);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), ",");

            String[] split = st.nextToken().split(" ");
            String countryA = split[2];
            int indexA = countryIndex.get(countryA);

            split = st.nextToken().split(" ");
            String countryB = split[2];
            int indexB = countryIndex.get(countryB);

            int winner = Integer.parseInt(st.nextToken());

            if (winner == 1) {
                union(indexA, indexB);
            } else {
                union(indexB, indexA);
            }
        }

        PriorityQueue<String> ans = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            if (parent[i] == i) {
                ans.add(countryName.get(i));
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(ans.size()).append('\n');
        while (!ans.isEmpty()) {
            String country = ans.poll();
            sb.append("Kingdom of ").append(country).append('\n');
        }

        System.out.print(sb);
    }
}
