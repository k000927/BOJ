import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int t;
    static int n;

    static class Applicant implements Comparable<Applicant> {
        int paper;
        int interview;

        Applicant(int paper, int interview) {
            this.paper = paper;
            this.interview = interview;
        }

        public int compareTo(Applicant o) {
            return this.paper - o.paper;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        t = Integer.parseInt(br.readLine());

        PriorityQueue<Applicant> pq;
        int minInterview;
        int ans;
        for (int i = 0; i < t; i++) {
            pq = new PriorityQueue<>();
            ans = 0;
            minInterview = Integer.MAX_VALUE;

            n = Integer.parseInt(br.readLine());

            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                pq.add(new Applicant(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }

            while(!pq.isEmpty()) {
                Applicant a = pq.poll();
                if(a.interview < minInterview){
                    minInterview = a.interview;
                    ans++;
                }
            }

            System.out.println(ans);
        }

    }
}