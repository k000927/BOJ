import java.io.*;
import java.util.*;

public class Main {
    static int a, b, c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        if ((a + b) == c) bw.write(String.format("%d+%d=%d", a, b, c));
        else if ((a - b) == c) bw.write(String.format("%d-%d=%d", a, b, c));
        else if ((a * b) == c) bw.write(String.format("%d*%d=%d", a, b, c));
        else if ((a / b) == c) bw.write(String.format("%d/%d=%d", a, b, c));
        else if (a == (b + c)) bw.write(String.format("%d=%d+%d", a, b, c));
        else if (a == (b - c)) bw.write(String.format("%d=%d-%d", a, b, c));
        else if (a == (b * c)) bw.write(String.format("%d=%d*%d", a, b, c));
        else bw.write(String.format("%d=%d/%d", a, b, c));

        bw.flush();
    }
}