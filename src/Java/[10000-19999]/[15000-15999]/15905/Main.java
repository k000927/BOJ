import java.io.*;
import java.util.*;

public class Main {
    static class Participant implements Comparable<Participant> {
        int prob;
        int penalty;

        public Participant(int prob, int penalty) {
            this.prob = prob;
            this.penalty = penalty;
        }

        @Override
        public int compareTo(Participant o) {
            if (o.prob != this.prob) return o.prob - this.prob;
            else return this.penalty - o.penalty;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        ArrayList<Participant> participants = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            participants.add(new Participant(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(participants);

        int ans = 0;
        for (int i = 5; i < N; i++) {
            if (participants.get(4).prob == participants.get(i).prob) ans++;
        }

        System.out.println(ans);
    }
}