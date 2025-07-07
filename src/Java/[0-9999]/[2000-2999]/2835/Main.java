import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, Q;
    static double[] view, dView;

    static int convert(String time) {
        StringTokenizer st = new StringTokenizer(time, ":");
        int HH = Integer.parseInt(st.nextToken());
        int MM = Integer.parseInt(st.nextToken());
        int SS = Integer.parseInt(st.nextToken());

        return HH * 60 * 60 + MM * 60 + SS;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        view = new double[86400];
        dView = new double[86401];

        int start, end;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), "-");

            start = convert(st.nextToken().strip());
            end = convert(st.nextToken().strip());

            dView[start]++;
            dView[end + 1]--;

            if (start > end) {
                dView[0]++;
                dView[86400]--;
            }
        }

        double size, sum;
        view[0] = dView[0];
        sum = dView[0];
        for (int i = 1; i < 86400; i++) {
            sum += dView[i];
            view[i] = sum + view[i - 1];
        }

        Q = Integer.parseInt(br.readLine());

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine(), "-");

            start = convert(st.nextToken().strip());
            end = convert(st.nextToken().strip());

            sum = 0;
            size = 0;
            if (start > end) {
                sum = view[end] + view[86399] - view[start];
                size = 86400 - (end - start + 1);
            } else {
                sum = view[end] - view[start];
                size = (end - start + 1);
            }

            ans.append(sum / size).append('\n');
        }

        System.out.println(ans);
    }
}
