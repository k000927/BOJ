import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        int k = Integer.parseInt(br.readLine());
        boolean[] isGood = new boolean[s.length()];

        PriorityQueue<String> pq = new PriorityQueue<>();
        while (true) {
            boolean flag = false;
            boolean openBracket = false;
            int length = 0;
            for (int i = 0; i < s.length(); i++) {
                if (openBracket) {
                    if (isGood[i]) {
                        length++;
                        continue;
                    } else {
                        if (s.charAt(i) == ')') {
                            flag = true;
                            String good = s.substring(i - length, i + 1);
                            if (!pq.contains(good)) {
                                pq.add(good);
                            }
                            isGood[i - length] = true;
                            isGood[i] = true;
                            openBracket = false;
                            length = 0;
                        } else {
                            length = 1;
                        }
                    }
                } else {
                    if (isGood[i]) {
                        continue;
                    } else {
                        if (s.charAt(i) == '(') {
                            openBracket = true;
                            length++;
                        }
                    }
                }
            }
            if (!flag) break;
        }
        System.out.println("pq = " + pq);
    }
}