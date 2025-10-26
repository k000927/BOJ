import com.sun.source.util.Trees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    static int N, Q, curPos;
    static TreeSet<Integer> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        set = new TreeSet<>();
        curPos = 1;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            if (Integer.parseInt(st.nextToken()) == 1)
                set.add(i);
        }

        for (int z = 0; z < Q; z++) {
            st = new StringTokenizer(br.readLine());

            int op = Integer.parseInt(st.nextToken());
            if (op == 1) {
                int i = Integer.parseInt(st.nextToken());
                if (!set.contains(i)) {
                    set.add(i);
                } else {
                    set.remove(i);
                }
            } else if (op == 2) {
                int x = Integer.parseInt(st.nextToken());
                curPos = ((curPos - 1) + x) % N + 1;
            } else {
                Integer next = set.ceiling(curPos);
                if (next == null) {
                    next = set.ceiling(1);
                    if (next == null) {
                        sb.append(-1).append('\n');
                    } else {
                        sb.append((N - curPos) + next).append('\n');
                    }
                } else {
                    sb.append(next - curPos).append('\n');
                }
            }
        }

        System.out.print(sb);
    }
}
