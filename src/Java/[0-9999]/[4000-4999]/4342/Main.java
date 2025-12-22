import java.io.*;
import java.util.*;

public class Main {
    static int P, Q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            P = Integer.parseInt(st.nextToken());
            Q = Integer.parseInt(st.nextToken());

            if (P == 0 && Q == 0) break;

            boolean turn = true;
            while (true) {
                if (P / Q > 1 || Q / P > 1 || P == Q) {
                    ans.append(turn ? "A wins" : "B wins").append("\n");
                    break;
                }

                if (P > Q)
                    P -= P / Q * Q;
                else
                    Q -= Q / P * P;
                turn = !turn;
            }
        }

        System.out.print(ans);
    }
}