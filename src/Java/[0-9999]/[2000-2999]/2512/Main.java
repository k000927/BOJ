import java.io.*;
import java.util.*;

public class Main {
    static int[] offer;
    static int m;
    static int ans;
    static int min_limit = 1000000000;

    static Boolean isOverBudget(int limit) {
        int temp = 0;
        for (int b : offer) {
            temp += Math.min(b, limit);
        }
        if (temp > m) return true;
        else {
            if (m-temp < min_limit){
                min_limit = m-temp;
                ans = limit;
            }
            return false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int start = 0;
        int end = 0;
        int limit = 0;

        offer = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            offer[i] = Integer.parseInt(st.nextToken());
            end = Math.max(offer[i], end);
        }

        m = Integer.parseInt(br.readLine());

        while (start <= end) {
            limit = (start + end) / 2;
            if (isOverBudget(limit)) end = limit - 1;
            else start = limit + 1;
        }

        System.out.println(ans);
    }
}