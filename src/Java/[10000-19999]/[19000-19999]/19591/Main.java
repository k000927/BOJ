import java.io.*;
import java.util.*;

public class Main {
    static Deque<Long> numDeque;
    static Deque<Character> opDeque;

    static long compute(long a, char op, long b) {
        if (op == '+') return a + b;
        else if (op == '-') return a - b;
        else if (op == '*') return a * b;
        else return a / b;
    }

    static void parsing(String exp) {
        long num = 0;
        boolean minus = false;
        if (exp.charAt(0) == '-') {
            minus = true;
        } else {
            num = exp.charAt(0) - '0';
        }
        for (int i = 1; i < exp.length(); i++) {
            char c = exp.charAt(i);
            if (c == '+' || c == '-' || c == '*' || c == '/') {
                if (minus) {
                    num *= -1;
                    minus = false;
                }
                numDeque.addLast(num);
                opDeque.addLast(c);
                num = 0;
            } else {
                num = num * 10 + (c - '0');
            }
        }
        if (minus) numDeque.addLast(num * -1);
        else numDeque.addLast(num);
    }

    static void print() {
        Deque<Long> copyOfNumDeque = new ArrayDeque<>();
        Deque<Character> copyOfOpDeque = new ArrayDeque<>();

        copyOfNumDeque.addAll(numDeque);
        copyOfOpDeque.addAll(opDeque);

        StringBuilder sb = new StringBuilder();
        while (!copyOfNumDeque.isEmpty()) {
            sb.append(copyOfNumDeque.removeFirst());
            if (!copyOfOpDeque.isEmpty()) sb.append(copyOfOpDeque.removeFirst());
        }
        System.out.println(sb);
    }

    static void solve() {
        Character frontOp = null, backOp = null;
        long frontRes = 0L, backRes = 0L, frontA = 0L, frontB = 0L, backA = 0L, backB = 0L;

        while (opDeque.size() > 1) {
//            print();
            frontOp = opDeque.poll();
            backOp = opDeque.pollLast();

            if ((frontOp == '*' || frontOp == '/') && (backOp == '+' || backOp == '-')) {
                frontA = numDeque.poll();
                frontB = numDeque.poll();
                frontRes = compute(frontA, frontOp, frontB);
                numDeque.addFirst(frontRes);
                opDeque.addLast(backOp);
            } else if ((backOp == '*' || backOp == '/') && (frontOp == '+' || frontOp == '-')) {
                backB = numDeque.pollLast();
                backA = numDeque.pollLast();
                backRes = compute(backA, backOp, backB);
                numDeque.addLast(backRes);
                opDeque.addFirst(frontOp);
            } else {
                frontA = numDeque.poll();
                frontB = numDeque.poll();
                numDeque.addFirst(frontB);
                numDeque.addFirst(frontA);

                backB = numDeque.pollLast();
                backA = numDeque.pollLast();
                numDeque.addLast(backA);
                numDeque.addLast(backB);

                frontRes = compute(frontA, frontOp, frontB);
                backRes = compute(backA, backOp, backB);

                if (frontRes >= backRes) {
                    frontA = numDeque.poll();
                    frontB = numDeque.poll();

                    numDeque.addFirst(frontRes);
                    opDeque.addLast(backOp);
                } else {
                    backB = numDeque.pollLast();
                    backA = numDeque.pollLast();

                    numDeque.addLast(backRes);
                    opDeque.addFirst(frontOp);
                }
            }
        }

        if (opDeque.isEmpty()) {
            System.out.println(numDeque.poll());
        } else {
            long A = numDeque.poll(), B = numDeque.pollLast();
            System.out.println(compute(A, opDeque.poll(), B));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        numDeque = new ArrayDeque<>();
        opDeque = new ArrayDeque<>();

        parsing(br.readLine());
        solve();
    }
}
