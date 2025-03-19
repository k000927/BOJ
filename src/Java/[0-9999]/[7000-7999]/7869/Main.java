import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static double x1, y1, r1, x2, y2, r2, dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        x1 = Double.parseDouble(st.nextToken());
        y1 = Double.parseDouble(st.nextToken());
        r1 = Double.parseDouble(st.nextToken());
        x2 = Double.parseDouble(st.nextToken());
        y2 = Double.parseDouble(st.nextToken());
        r2 = Double.parseDouble(st.nextToken());

        dist = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

        double area = 0;

        if (dist >= r1 + r2)
            area = 0;

        else if (dist <= Math.abs(r1 - r2))
            area = Math.PI * Math.pow(Math.min(r1, r2), 2);

        else {
            double alpha = Math.acos((r1 * r1 + dist * dist - r2 * r2) / (2 * r1 * dist));
            double beta = Math.acos((r2 * r2 + dist * dist - r1 * r1) / (2 * r2 * dist));

            double area1 = (r1 * r1 * alpha) - (r1 * r1 * Math.sin(2 * alpha) / 2);
            double area2 = (r2 * r2 * beta) - (r2 * r2 * Math.sin(2 * beta) / 2);

            area = area1 + area2;
        }

        System.out.printf("%.3f\n", area);
    }
}
