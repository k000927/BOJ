import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static ArrayList<Integer>[] adj;
    static ArrayList<Integer> ans;
    static StringTokenizer st;
    static Musician[] musicians;

    static class Musician {
        int num;
        int inDegree;

        Musician(int num, int inDegree) {
            this.num = num;
            this.inDegree = inDegree;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        musicians = new Musician[n + 1];
        adj = new ArrayList[n + 1];
        ans = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            musicians[i] = new Musician(i, 0);
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int prevMusician = 0;
            int currMusician = 0;
            st = new StringTokenizer(br.readLine());

            int k = Integer.parseInt(st.nextToken());

            for (int j = 0; j < k; j++) {
                currMusician = Integer.parseInt(st.nextToken());
                if (prevMusician != 0) {
                    adj[prevMusician].add(currMusician);
                    musicians[currMusician].inDegree++;
                }
                prevMusician = currMusician;
            }
        }

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i < n + 1; i++) {
            if (musicians[i].inDegree == 0) queue.add(i);
        }


        while (!queue.isEmpty()) {
            int curMusician = queue.poll();
            ans.add(curMusician);

            for (Integer i : adj[curMusician]) {
                musicians[i].inDegree--;
                if (musicians[i].inDegree == 0) queue.add(i);
            }
        }

        if (ans.size() != n) System.out.println(0);
        else {
            for (Integer i : ans) {
                System.out.println(i);
            }
        }
    }
}