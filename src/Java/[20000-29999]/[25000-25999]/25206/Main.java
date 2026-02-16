import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double a = 0;
        int b = 0;

        String input;
        while ((input = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(input);

            String course = st.nextToken();
            double score = Double.parseDouble(st.nextToken());
            String cls = st.nextToken();

            if (cls.equals("P")) continue;

            if (cls.equals("A+")) a += score * 4.5;
            else if (cls.equals("A0")) a += score * 4.0;
            else if (cls.equals("B+")) a += score * 3.5;
            else if (cls.equals("B0")) a += score * 3.0;
            else if (cls.equals("C+")) a += score * 2.5;
            else if (cls.equals("C0")) a += score * 2.0;
            else if (cls.equals("D+")) a += score * 1.5;
            else if (cls.equals("D0")) a += score;

            b += (int) score;
        }

        System.out.println(a / b);
    }
}