import java.io.*;
import java.util.*;

public class Main {
    static Long atoi(String str) {
        return Long.parseLong(str);
    }

    static HashMap<String, String> hm = new HashMap<>();
    static String s;
    static ArrayList<Character> op = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    static Deque<Long> dq = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        input();
        pro();

        System.out.println(sb);
    }

    static void pro() {
        StringTokenizer st = new StringTokenizer(s, "+-x/=");

        if(st.countTokens() < op.size()){
            sb.append("Madness!");
            return;
        }

        int opIdx = 0;
        long sum = 0L;

        //1
        while (st.hasMoreTokens()) {
            String rel = stringToNum(st.nextToken());

            if(rel == null){
                sb.append("Madness!");
                return;
            }

            sb.append(rel).append(op.get(opIdx++));
            dq.offer(atoi(rel));
        }

        sb.append("\n");

        //2
        opIdx = 0;
        while (dq.size() >= 2) {
            long l1 = dq.poll();
            long l2 = dq.poll();

            long rel = calcul(l1, l2, op.get(opIdx));
            opIdx++;
            dq.offerFirst(rel);
        }


        //3
        long l = dq.poll();
        sb.append(numToString(l));

    }

    static String numToString(Long l) {
        String strL = String.valueOf(l);
        String rel = "";
        for (int i = 0; i < strL.length(); i++) {
            if(strL.charAt(i) == '+' || strL.charAt(i) == '-' || strL.charAt(i) == 'x' ||
                    strL.charAt(i) == '/' || strL.charAt(i) == '='){
                rel += strL.charAt(i);
            }
            else rel += hm.get(strL.charAt(i) + "");
        }

        return rel;
    }

    static Long calcul(long l1, long l2, char op) {
        long rel = 0L;
        switch (op) {
            case '+':
                rel = l1 + l2;
                break;
            case '-':
                rel = l1 - l2;
                break;
            case 'x':
                rel = l1 * l2;
                break;
            case '/':
                rel = l1 / l2;
                break;
        }
        return rel;
    }

    static String stringToNum(String target) {
        String rel = "";
        String num = "";
        int s = 0, e = 0;

        while (true) {
            e++;
            String mid = target.substring(s, e);
            if (hm.get(mid) != null) {
                rel += mid;
                num += hm.get(mid);
                s = e;
            }
            if(e == target.length()) break;
        }

        if(rel.length() == target.length()) return num;
        return null;

    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '+' || s.charAt(i) == '-' ||s.charAt(i) == 'x' ||
                    s.charAt(i) == '/' || s.charAt(i) == '='){
                op.add(s.charAt(i));
            }
        }

        hm.put("ZERO", "0");
        hm.put("ONE", "1");
        hm.put("TWO", "2");
        hm.put("THREE", "3");
        hm.put("FOUR", "4");
        hm.put("FIVE", "5");
        hm.put("SIX", "6");
        hm.put("SEVEN", "7");
        hm.put("EIGHT", "8");
        hm.put("NINE", "9");

        hm.put("0", "ZERO");
        hm.put("1", "ONE");
        hm.put("2", "TWO");
        hm.put("3", "THREE");
        hm.put("4", "FOUR");
        hm.put("5", "FIVE");
        hm.put("6", "SIX");
        hm.put("7", "SEVEN");
        hm.put("8", "EIGHT");
        hm.put("9", "NINE");
    }
}
