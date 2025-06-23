import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] A, F, NFG;
    static Stack<Integer> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        A = new int[1000001];
        F = new int[1000001];
        NFG = new int[1000001];
        stack = new Stack<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            F[A[i]]++;
        }

        for (int i = N - 1; i >= 0; i--) {
            while (!stack.isEmpty() && F[stack.get(stack.size() - 1)] <= F[A[i]])
                stack.pop();

            if (stack.empty()) NFG[i] = -1;
            else NFG[i] = stack.get(stack.size() - 1);

            stack.push(A[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(NFG[i]).append(' ');
        }
        System.out.println(sb);
    }
}