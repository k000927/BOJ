import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int totalLevel = 0;
        int totalUnion = 0;
        for (int i = 0; i < N; i++) {
            int level = Integer.parseInt(br.readLine());

            totalLevel += level;
            if (level < 60)
                totalUnion += 0;
            else if (level < 100)
                totalUnion += 1;
            else if (level < 140)
                totalUnion += 2;
            else if (level < 200)
                totalUnion += 3;
            else if (level < 250)
                totalUnion += 4;
            else
                totalUnion += 5;

            pq.add(level);

            if (pq.size() == 43) {
                int popLevel = pq.poll();
                totalLevel -= popLevel;
                if (popLevel < 60)
                    continue;
                else if (popLevel < 100)
                    totalUnion -= 1;
                else if (popLevel < 140)
                    totalUnion -= 2;
                else if (popLevel < 200)
                    totalUnion -= 3;
                else if (popLevel < 250)
                    totalUnion -= 4;
                else
                    totalUnion -= 5;
            }
        }

        System.out.println(totalLevel + " " + totalUnion);
    }
}