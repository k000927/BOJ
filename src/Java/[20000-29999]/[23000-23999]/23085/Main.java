import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {
    static class State {
        int h;
        int t;
        int time;

        State(int h, int t, int time) {
            this.h = h;
            this.t = t;
            this.time = time;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            State state = (State) o;
            return h == state.h && t == state.t;
        }

        @Override
        public int hashCode() {
            return Objects.hash(h, t);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        HashSet<State> visited = new HashSet<>();
        ArrayList<State> stateList = new ArrayList<>();

        String coin = br.readLine();
        int hNum = 0;
        int tNum = 0;
        for (int i = 0; i < n; i++) {
            if (coin.charAt(i) == 'H') hNum++;
            else tNum++;
        }

        visited.add(new State(hNum, tNum, 0));
        stateList.add(new State(hNum, tNum, 0));

        while (!stateList.isEmpty()) {
            State curState = stateList.remove(0);
            for (int i = 0; i < k + 1; i++) {
                if (curState.t - i < 0 || curState.h - k + i < 0) continue;
                int nextH = curState.h + i - (k - i);
                int nextT = curState.t - i + (k - i);

                if (nextH < 0 || nextT < 0 || nextH > n || nextT > n) continue;

                State nextState = new State(nextH, nextT, curState.time + 1);
                if (visited.contains(nextState)) continue;

                if (nextT == n) {
                    System.out.println(curState.time + 1);
                    System.exit(0);
                }

                visited.add(nextState);
                stateList.add(nextState);
            }
        }
        System.out.println(-1);
    }
}