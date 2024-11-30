import java.io.*;
import java.util.*;

public class Main {
    static HashMap<String, Integer> prior = new HashMap<>();
    static ArrayList<String> exp = new ArrayList<>();
    static Deque<String> deque;

    static void calc(int index) {
        long pre = Long.parseLong(deque.removeLast());
        long post = Long.parseLong(exp.get(index + 1));
        long cal;
        if (exp.get(index).equals("+")) {
            cal = pre + post;
        } else if (exp.get(index).equals("-")) {
            cal = pre - post;
        } else if (exp.get(index).equals("*")) {
            cal = pre * post;
        } else {
            cal = pre / post;
        }

        deque.addLast(Long.toString(cal));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        prior.put("+", Integer.parseInt(st.nextToken()));
        prior.put("-", Integer.parseInt(st.nextToken()));
        prior.put("*", Integer.parseInt(st.nextToken()));
        prior.put("/", Integer.parseInt(st.nextToken()));

        String line = br.readLine();

        StringBuilder sb = new StringBuilder();
        for (int i = line.length() - 1; i >= 0; i--) {
            if (prior.containsKey(line.charAt(i))) {
                exp.add(sb.reverse().toString());
                exp.add(String.valueOf(line.charAt(i)));
                sb = new StringBuilder();
            } else sb.append(line.charAt(i));
        }
        exp.add(sb.reverse().toString());

        for (int curP = 4; curP >= 1; curP--) {
            deque = new ArrayDeque<>();
            int i = 0;

            while (i < exp.size()) {
                if (prior.containsKey(exp.get(i)) && prior.get(exp.get(i)) == curP) {
                    calc(i);
                    i += 2;
                } else {
                    deque.add(exp.get(i));
                    i++;
                }
            }

            exp.clear();
            while (!deque.isEmpty()) {
                exp.add(deque.pop());
            }
        }

        System.out.println(Long.parseLong(exp.get(0)));
    }
}