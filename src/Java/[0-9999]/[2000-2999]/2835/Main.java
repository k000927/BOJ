import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, Q;
    static final int END = 60*60*24;
    static int[] prefixSum;
    static long[] time;
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        prefixSum = new int[24 * 60 * 60 + 1];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            st = new StringTokenizer(line, " :-");
            int start = calTime(st);
            int end = calTime(st);

            if(start <= end){
                prefixSum[start]++;
                prefixSum[end+1]--;
            }
            else{
                prefixSum[start]++;
                prefixSum[END]--;
                prefixSum[0]++;
                prefixSum[end+1]--;
            }
        }
        for (int i = 1; i <= END; i++) {
            prefixSum[i] += prefixSum[i-1];
        }

        time = new long[END];
        for (int i = 0; i < END; i++) {
            if(i==0) time[0] = prefixSum[0];
            else time[i] = time[i-1] + prefixSum[i];
        }

        Q = Integer.parseInt(br.readLine());
        while(Q-->0){
            String line = br.readLine();
            st = new StringTokenizer(line, " :-");
            int start = calTime(st);
            int end = calTime(st);

            double avg = 0;

            if(start <= end){
                if(start != 0) avg = (double) (time[end] - time[start - 1]) / (end+1-start);
                else avg = (double) time[end] / (end+1-start);
            }
            else{
                avg = (double) ((time[END - 1] - time[start - 1]) + time[end]) / ((END-start) + (end+1));
            }
            sb.append(String.format("%.10f", avg)).append("\n");
        }

        System.out.println(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private int calTime(StringTokenizer st){
        return 3600 * Integer.parseInt(st.nextToken()) + 60 * Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
    }
}