import java.io.*;
import java.util.*;

public class Main {
    static class Problem implements Comparable<Problem> {
        int num;
        int diff;

        Problem(int num, int diff) {
            this.num = num;
            this.diff = diff;
        }

        @Override
        public int compareTo(Problem o) {
            if (this.diff != o.diff) return Integer.compare(this.diff, o.diff);
            return Integer.compare(this.num, o.num);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        // 그룹별 문제셋 (난이도,문제번호 오름차순)
        Map<Integer, TreeSet<Problem>> problemMap = new HashMap<>();
        // 전체 문제셋
        TreeSet<Problem> allProblems = new TreeSet<>();
        // 문제번호 -> (난이도, 그룹)
        Map<Integer, int[]> infoMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            int G = Integer.parseInt(st.nextToken());

            problemMap.computeIfAbsent(G, k -> new TreeSet<>()).add(new Problem(P, L));
            allProblems.add(new Problem(P, L));
            infoMap.put(P, new int[]{L, G});
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            if (cmd.equals("recommend")) {
                int G = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                TreeSet<Problem> set = problemMap.get(G);
                if (x == 1) {
                    sb.append(set.last().num).append('\n');
                } else {
                    sb.append(set.first().num).append('\n');
                }
            } else if (cmd.equals("recommend2")) {
                int x = Integer.parseInt(st.nextToken());
                if (x == 1) {
                    sb.append(allProblems.last().num).append('\n');
                } else {
                    sb.append(allProblems.first().num).append('\n');
                }
            } else if (cmd.equals("recommend3")) {
                int x = Integer.parseInt(st.nextToken());
                int L = Integer.parseInt(st.nextToken());
                if (x == 1) {
                    // 난이도 >= L 중 가장 쉬운 (따라서 ceiling with diff=L, num = MIN_VALUE)
                    Problem probe = new Problem(Integer.MIN_VALUE, L);
                    Problem cand = allProblems.ceiling(probe);
                    if (cand == null) sb.append(-1).append('\n');
                    else sb.append(cand.num).append('\n');
                } else {
                    // 난이도 < L 중 가장 어려운 -> 난이도 <= L-1 중 가장 큰 것
                    Problem probe = new Problem(Integer.MAX_VALUE, L - 1);
                    Problem cand = allProblems.floor(probe);
                    if (cand == null) sb.append(-1).append('\n');
                    else sb.append(cand.num).append('\n');
                }
            } else if (cmd.equals("add")) {
                int P = Integer.parseInt(st.nextToken());
                int L = Integer.parseInt(st.nextToken());
                int G = Integer.parseInt(st.nextToken());

                problemMap.computeIfAbsent(G, k -> new TreeSet<>()).add(new Problem(P, L));
                allProblems.add(new Problem(P, L));
                infoMap.put(P, new int[]{L, G});
            } else if (cmd.equals("solved")) {
                int P = Integer.parseInt(st.nextToken());
                int[] info = infoMap.remove(P); // 반드시 존재한다고 문제에서 보장
                int L = info[0];
                int G = info[1];

                TreeSet<Problem> set = problemMap.get(G);
                if (set != null) {
                    set.remove(new Problem(P, L));
                    if (set.isEmpty()) {
                        problemMap.remove(G); // 선택사항
                    }
                }
                allProblems.remove(new Problem(P, L));
            }
        }

        System.out.print(sb.toString());
    }
}
