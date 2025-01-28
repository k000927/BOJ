import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int n;
    static int m;
    static TreeSet<Problem> problemTree;
    static HashMap<Integer, Integer> problemMap;
    static StringBuilder ans = new StringBuilder();


    static void recommendProblem() {
        int recommendMode = Integer.parseInt(st.nextToken());

        if (recommendMode == 1) {
            ans.append(problemTree.last().num).append("\n");
        } else {
            ans.append(problemTree.first().num).append("\n");
        }
    }

    static void addProblem() {
        int num = Integer.parseInt(st.nextToken());
        int diff = Integer.parseInt(st.nextToken());

        Problem newProblem = new Problem(num, diff);

        problemTree.add(newProblem);
        problemMap.put(num, diff);
    }

    static void solveProblem() {
        int num = Integer.parseInt(st.nextToken());
        int diff = problemMap.get(num);
        problemTree.remove(problemTree.floor(new Problem(num, diff)));
        problemMap.remove(num);
    }


    static class Problem implements Comparable<Problem> {
        int num;
        int diff;

        Problem(int num, int diff) {
            this.num = num;
            this.diff = diff;
        }

        @Override
        public int compareTo(Problem o) {
            if (this.diff != o.diff) return this.diff - o.diff;
            return this.num - o.num;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        problemTree = new TreeSet<>();
        problemMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            addProblem();
        }

        m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            String op = st.nextToken();

            switch (op) {
                case "recommend":
                    recommendProblem();
                    break;
                case "add":
                    addProblem();
                    break;
                case "solved":
                    solveProblem();
            }
        }

        System.out.println(ans);
    }
}