import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * DFS를 이용해서 풀이
 * 깊이 4 이상 탐색할 수 있다면 1을 출력, 아니라면 0을 출력
 */

public class Main {
    static final StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    // 사람의 수
    static int N;
    // 관계의 수
    static int M;
    // 인접 리스트
    static ArrayList<Integer>[] adjList;
    // 방문 배열
    static boolean[] visited;

    static void dfs(int curNode, int cnt) {
        if (cnt == 5) {
            System.out.println(1);
            System.exit(0);
        }


        for (int nextFriend : adjList[curNode]) {
            if (visited[nextFriend])
                continue;

            visited[nextFriend] = true;
            dfs(nextFriend, cnt + 1);
            visited[nextFriend] = false;
        }

    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            adjList[i] = new ArrayList<>();
        }

        int a, b;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            adjList[a].add(b);
            adjList[b].add(a);
        }

        for (int i = 0; i < N; i++) {
            visited[i] = true;
            dfs(i, 1);
            visited[i] = false;
        }

        System.out.println(0);
    }
}