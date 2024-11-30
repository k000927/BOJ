import java.io.*;
import java.util.*;

public class Main {
    static String exp;
    static PriorityQueue<String> ans;
    static Deque<String> deque;
    static String[] split;
    static int i;
    static int sum;


    static void sum(String e) {
        split = e.split(" ");
        deque = new ArrayDeque<>();

        i = 0;
        while (i < split.length) {
            if (split[i].equals("*")) {
                deque.addLast(String.valueOf(Integer.parseInt(deque.removeLast()) * Integer.parseInt(split[++i])));
            } else deque.addLast(split[i]);
            i++;
        }

        sum = Integer.parseInt(Objects.requireNonNull(deque.poll()));
        while (!deque.isEmpty()) {
            if (deque.poll().equals("+")) sum += Integer.parseInt(deque.pop());
            else sum -= Integer.parseInt(deque.pop());
        }

        if (sum == 2000) ans.add(e.replace(" ", ""));
    }

    static void solve(int index, StringBuilder curExp, boolean flag) {
        if (index == exp.length()) {
            sum(curExp.toString());
        } else {
            int length = curExp.length();
            if (!flag) {
                solve(index + 1, curExp.append(exp.charAt(index)), false);
                curExp.setLength(length);
            }
            solve(index + 1, curExp.append(" + ").append(exp.charAt(index)), '0' == exp.charAt(index));
            curExp.setLength(length);
            solve(index + 1, curExp.append(" - ").append(exp.charAt(index)), '0' == exp.charAt(index));
            curExp.setLength(length);
            solve(index + 1, curExp.append(" * ").append(exp.charAt(index)), '0' == exp.charAt(index));
            curExp.setLength(length);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ans = new PriorityQueue<>();

        exp = br.readLine();
        solve(1, new StringBuilder(String.valueOf(exp.charAt(0))), exp.charAt(0) == '0');

        while (!ans.isEmpty()) {
            System.out.println(ans.poll());
        }
    }
}