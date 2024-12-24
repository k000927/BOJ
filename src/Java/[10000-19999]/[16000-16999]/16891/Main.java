import java.io.*;
import java.util.*;

public class Main {
    static int ans = 0;
    static int n;

    static class Obj {
        double v;
        double m;

        Obj(double v, double m) {
            this.v = v;
            this.m = m;
        }
    }

    static void impulse(Obj a, Obj b) {
        double u1 = a.v;
        double u2 = b.v;
        double m1 = a.m;
        double m2 = b.m;

        double v1 = (m1 - m2) / (m1 + m2) * u1 + 2 * m2 / (m1 + m2) * u2;
        double v2 = 2 * m1 / (m1 + m2) * u1 - (m1 - m2) / (m1 + m2) * u2;

        a.v = v1;
        b.v = v2;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        Obj a = new Obj(0, 1);
        Obj b = new Obj(-1, n * n);

        while (true) {
            impulse(a, b);
            ans++;

            if (a.v < 0 && a.v < b.v) {
                a.v *= -1;
                ans++;
            }

            if (b.v > 0 && Math.abs(a.v) < Math.abs(b.v)) break;
        }

        System.out.println(ans);
    }
}