import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Main {
    static int[] num;
    static int N, ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        num = new int[100002];
        for (int i = 1; i <= N; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }
        Deque<Integer> stack = new LinkedList<>();
        stack.push(0);
        for (int i = 1; i <= N + 1; i++) {
            while (!stack.isEmpty() && num[stack.peek()] > num[i]) {
                int check = stack.peek();
                stack.pop();
                ans = Math.max(ans, num[check] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }

        System.out.println(ans);
    }
}
