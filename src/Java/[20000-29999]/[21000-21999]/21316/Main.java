import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int[] numEdges = new int[13];
        ArrayList<Integer>[] graph = new ArrayList[13];
        for (int i = 1; i < 13; i++) graph[i] = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 12; i++) {
            StringTokenizer line = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(line.nextToken());
            int b = Integer.parseInt(line.nextToken());
            numEdges[a]++;
            numEdges[b]++;
            graph[a].add(b);
            graph[b].add(a);
        }

        int spica = -1;
        for (int i = 1; i <= 12; i++) {
            if (numEdges[i] != 3) continue;

            int sum = 0;
            for (int adj : graph[i]) sum += numEdges[adj];
            if (sum == 6) {
                spica = i;
                break;
            }
        }

        System.out.println(spica);
    }
}