import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int[] visitor = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            visitor[i] = Integer.parseInt(st.nextToken());
        }

        int max_days = 0;
        int max_length = 1;
        for (int i = 0; i < x; i++) {
            max_days += visitor[i];
        }
        int cur_days = max_days;


        for (int i = 0; i < n - x; i++) {
            cur_days -= visitor[i];
            cur_days += visitor[i + x];
            if(cur_days == max_days) max_length++;
            else if (cur_days > max_days){
                max_days = cur_days;
                max_length = 1;
            }
        }

        if(max_days == 0) System.out.println("SAD");
        else{
            System.out.println(max_days);
            System.out.println(max_length);
        }
    }
}