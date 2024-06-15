import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        double s = Double.parseDouble(st.nextToken());
        double m = Double.parseDouble(st.nextToken());
        double l = Double.parseDouble(st.nextToken());
        double xl = Double.parseDouble(st.nextToken());
        double xxl = Double.parseDouble(st.nextToken());
        double xxxl = Double.parseDouble(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        int ans_shirts = 0;
        ans_shirts += (int) Math.ceil(s / t);
        ans_shirts += (int) Math.ceil(m / t);
        ans_shirts += (int) Math.ceil(l / t);
        ans_shirts += (int) Math.ceil(xl / t);
        ans_shirts += (int) Math.ceil(xxl / t);
        ans_shirts += (int) Math.ceil(xxxl / t);

        int pen_group = (int) (Math.floor((double) n / p));
        int pen_solo = n - pen_group * p;

        System.out.println(ans_shirts);
        System.out.println(pen_group + " " + pen_solo);
    }
}