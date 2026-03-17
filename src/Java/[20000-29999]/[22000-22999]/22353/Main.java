import java.io.*;
import java.util.*;

public class Main {
    static int a, d, k;
    static double ans, p;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        List<Double> pList = new LinkedList<>();
        double winP = (double) d / 100;
        while (true) {
            double temp = 1;
            for (Double p : pList) {
                temp *= (1 - p);
            }
            temp *= (pList.size() + 1) * a * winP;
            ans += temp;
            pList.add(winP);
            if (winP == 1.0) break;
            winP *= (double) (100 + k) / 100;
            winP = Math.min(winP, 1.0);
        }

        System.out.println(ans);
    }
}