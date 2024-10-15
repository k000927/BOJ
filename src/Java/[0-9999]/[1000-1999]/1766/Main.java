import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static StringTokenizer st;
    static BufferedWriter bw;
    static Prob[] problems;
    static ArrayList<Integer>[] adj;
    static int index = 0;


    static class Prob {
        int probNum;
        int inDegree;
        boolean visited;

        Prob(int probNum) {
            this.probNum = probNum;
            this.inDegree = 0;
            visited = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        problems = new Prob[n + 1];
        adj = new ArrayList[n + 1];

        for (int i = 1; i < n + 1; i++) {
            adj[i] = new ArrayList<>();
            problems[i] = new Prob(i);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            adj[start].add(end);
            problems[end].inDegree += 1;
        }

        while (index++ < n) {
            int probNum = -1;
            for (int i = 1; i < n + 1; i++) {
                if (problems[i].inDegree == 0 && !problems[i].visited) {
                    probNum = i;
                    break;
                }
            }

            bw.write(probNum + " ");
            problems[probNum].visited = true;
            for (Integer i : adj[probNum]) {
                problems[i].inDegree--;
            }
        }

        bw.write("\n");
        bw.flush();
        bw.close();
    }
}