import java.io.*;
import java.util.*;

public class Main {
    static int[] num;
    static Boolean[] isCycle;
    static Boolean[] visited;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        num = new int[n + 1];
        isCycle = new Boolean[n + 1]; // 사이클 여부를 판단하기 위한 배열
        visited = new Boolean[n + 1]; // 무한 루프를 방지하기 위한 방문 여부 저장하는 배열
        Arrays.fill(isCycle, false);
        int ans = 0;


        for (int i = 1; i <= n; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= n; i++) {
            if (isCycle[i]) continue; // 이미 사이클이 형성된 노드라면 무시한다.
            Arrays.fill(visited, false);

            visited[i] = true;
            ArrayList<Integer> list = new ArrayList<>();
            list.add(i);

            while (!visited[num[list.get(list.size() - 1)]]) {
                int next = num[list.get(list.size() - 1)];
                list.add(next);
                visited[next] = true;
            }

            if (list.get(0) == num[list.get(list.size() - 1)]) {
                // 만약 마지막 노드에서 첫 노드로 가는 간선이 존재할 경우 -> 즉 사이클이 형성된 경우
                for (int j = 0; j < list.size(); j++) {
                    ans++;
                    isCycle[list.get(j)] = true;
                }
            }
        }

        System.out.println(ans);

        for (int i = 1; i <= n; i++) {
            if(isCycle[i]) System.out.println(i);
        }
    }
}