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
        isCycle = new Boolean[n + 1];
        visited = new Boolean[n + 1];
        Arrays.fill(isCycle, false);
        int ans = 0;


        for (int i = 1; i <= n; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= n; i++) {
            if (isCycle[i]) continue;
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