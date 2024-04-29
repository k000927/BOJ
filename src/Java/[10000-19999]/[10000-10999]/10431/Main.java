import java.io.*;
import java.sql.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            ArrayList<Integer> arr = new ArrayList<>();
            arr.add(0);
            StringTokenizer st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());
            int ans = 0;
            for (int j = 0; j < 20; j++) {
                int student = Integer.parseInt(st.nextToken());
                for (int k = arr.size() - 1; k >= 0; k--) {
                    if (student > arr.get(k)) {
                        arr.add(k+1, student);
                        break;
                    } else ans++;
                }
            }
            System.out.println(num + " " + ans);
        }

    }
}