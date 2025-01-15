import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        int a;
        int b;
        int c;
        int floor;
        int preTemp;
        int temp;
        int plus;
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            floor = 1;
            preTemp = 0;
            temp = a;
            plus = a;
            while (true) {
                if (temp < c) {
                    plus += b;
                    preTemp = temp;
                    temp += plus;
                    floor += 1;
                } else if (temp > c) {
                    bw.write(floor + " " + (c - preTemp) + "\n");
                    break;
                } else if (temp == c) {
                    bw.write(floor + " " + (temp - preTemp) + "\n");
                    break;
                }
            }
        }
        bw.flush();
    }
}