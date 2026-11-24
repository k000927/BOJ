import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static List<Integer> stack = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            switch (Integer.parseInt(st.nextToken())) {
                case 1 -> push(Integer.parseInt(st.nextToken()));
                case 2 -> sb.append(pop()).append('\n');
                case 3 -> sb.append(size()).append('\n');
                case 4 -> sb.append(isEmpty()).append('\n');
                case 5 -> sb.append(top()).append('\n');
            }
        }

        System.out.print(sb.toString());
    }

    static void push(int x) {
        stack.add(x);
    }

    static int pop() {
        return stack.isEmpty() ? -1 : stack.remove(stack.size() - 1);
    }

    static int size() {
        return stack.size();
    }

    static int isEmpty() {
        return stack.isEmpty() ? 1 : 0;
    }

    static int top() {
        return stack.isEmpty() ? -1 : stack.get(stack.size() - 1);
    }
}
