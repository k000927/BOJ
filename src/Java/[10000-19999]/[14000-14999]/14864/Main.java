import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] ans;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ans = new int[N + 1];
        visited = new boolean[N + 1];
        for (int i = 0; i <= N; i++) {
            ans[i] = i;
        }

        while(M-- > 0){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            ans[a]++;
            ans[b]--;
        }

        for (int i = 1; i <= N; i++) {
            if(ans[i] <= 0 || ans[i] > N || visited[ans[i]]){
                System.out.println(-1);
                System.exit(0);
            }
            visited[ans[i]] = true;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(ans[i]).append(" ");
        }
        System.out.println(sb);
    }
}