import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] ary1 = new int[n];
        for (int i = 0; i < n; i++) {

            ary1[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] ary2 = new int[m];
        for (int i = 0; i < m; i++) {
            ary2[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> result = new ArrayList<>();

        int start1 = 0;
        int start2 = 0;
        int i= 100;
        while (i > 0) {
            boolean hasI = false;
            boolean hasJ = false;
            int tmpStart1 = 0;
            int tmpStart2 = 0;

            for (int j = start1; j < n; j++) {
                if (ary1[j] == i) {
                    hasI = true;
                    tmpStart1 = j;
                    break;
                }
            }

            for (int j = start2; j < m; j++) {
                if (ary2[j] == i) {
                    hasJ = true;
                    tmpStart2 = j;
                    break;
                }
            }

            if (hasI && hasJ) {
                result.add(i);
                start1 = tmpStart1 + 1;
                start2 = tmpStart2 + 1;
                continue;
            }
            i--;
        }

        sb.append(result.size()).append('\n');

        for (Integer integer : result) {
            sb.append(integer).append(" ");
        }

        System.out.println(sb);
    }

}