import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] people = new int[n];
        Arrays.fill(people, -1);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int taller = Integer.parseInt(st.nextToken());
            for (int j = 0; j < n; j++) {
                if (taller == 0 && people[j] == -1) {
                    people[j] = i + 1;
                    break;
                }
                if(people[j] == -1){
                    taller--;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.printf("%d ", people[i]);
        }
        bw.flush();
    }
}