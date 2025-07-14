import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static Work[] works;
    static List<List<Integer>> workOrder;

    static class Work {
        int indegree, time, startTime;

        Work() {
            this.indegree = 0;
            this.time = 0;
            this.startTime = 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        workOrder = new ArrayList<>();
        works = new Work[N + 1];

        for (int i = 0; i <= N; i++) {
            workOrder.add(new ArrayList<>());
            works[i] = new Work();
        }

        StringTokenizer st;

        int time, k, prevWork;
        for (int work = 1; work <= N; work++) {
            st = new StringTokenizer(br.readLine());

            time = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            for (int i = 0; i < k; i++) {
                prevWork = Integer.parseInt(st.nextToken());
                works[work].indegree++;
                workOrder.get(prevWork).add(work);
            }

            works[work].time = time;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (works[i].indegree == 0)
                queue.add(i);
        }

        int curWork;
        while (!queue.isEmpty()) {
            curWork = queue.poll();
            for (int i : workOrder.get(curWork)) {
                works[i].startTime = Math.max(works[curWork].startTime + works[curWork].time, works[i].startTime);
                if (--works[i].indegree == 0) {
                    queue.add(i);
                }
            }
        }

        int ans = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            ans = Math.max(works[i].startTime + works[i].time, ans);
        }

        System.out.println(ans);
    }
}
