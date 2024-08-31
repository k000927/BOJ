import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] friend;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        friend = new int[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(friend[i], 1000000000);
        }

        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a == -1 && b == -1) break;
            friend[a][b] = 1;
            friend[b][a] = 1;
        }

        for (int x = 0; x < n + 1; x++) {
            for (int i = 0; i < n + 1; i++) {
                for (int j = 0; j < n + 1; j++) {
                    if (i == j) continue;
                    friend[i][j] = Math.min(friend[i][x] + friend[x][j], friend[i][j]);
                }
            }
        }

        int score = 1000000000;
        ArrayList<Integer> candidateList = new ArrayList<>();

        for (int i = 1; i < n + 1; i++) {
            int tempScore = -1;
            for (int j = 1; j < n + 1; j++) {
                if (i == j) continue;
                tempScore = Math.max(tempScore, friend[i][j]);
            }
            if (score > tempScore) {
                score = tempScore;
                candidateList = new ArrayList<>();
                candidateList.add(i);
            } else if (score == tempScore) {
                candidateList.add(i);
            }
        }

        System.out.println(score + " " + candidateList.size());
        for (Integer i : candidateList) {
            System.out.print(i + " ");
        }
    }
}