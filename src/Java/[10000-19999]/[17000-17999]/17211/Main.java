import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int mood = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        double good_to_good = Double.parseDouble(st.nextToken());
        double good_to_bad = Double.parseDouble(st.nextToken());
        double bad_to_good = Double.parseDouble(st.nextToken());
        double bad_to_bad = Double.parseDouble(st.nextToken());

        double[] bad = new double[n + 1];
        double[] good = new double[n + 1];
        Arrays.fill(bad, 0);
        Arrays.fill(good, 0);


        if (mood == 1) bad[0] = 1;
        else good[0] = 1;
        for (int i = 1; i < n + 1; i++) {
            good[i] = bad[i - 1] * bad_to_good + good[i - 1] * good_to_good;
            bad[i] = good[i - 1] * good_to_bad + bad[i - 1] * bad_to_bad;
        }

        System.out.println(Math.round(good[n] * 1000));
        System.out.println(Math.round(bad[n] * 1000));
    }
}