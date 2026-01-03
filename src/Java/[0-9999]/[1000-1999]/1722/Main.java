import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static boolean[] visited;
    static long[] fact;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        visited = new boolean[N + 1];
        fact = new long[N];
        fact[0] = 1;
        for (int i = 1; i < N; i++) {
            fact[i] = fact[i - 1] * i;
        }

        st = new StringTokenizer(br.readLine());

        if (st.nextToken().equals("1")) {
            long th = Long.parseLong(st.nextToken()) - 1;
            for (int i = N; i > 0; i--) {
                long ith = th / fact[i - 1] + 1;
                th %= fact[i - 1];
                long count = 0;
                int index = 0;
                while (count != ith) {
                    index++;
                    if (!visited[index]) count++;
                }
                visited[index] = true;
                ans.append(index).append(" ");
            }
        } else {
            long th = 1;
            for (int i = N; i > 0; i--) {
                int data = Integer.parseInt(st.nextToken());
                int index = 0;
                int count = 0;
                while (index != data) {
                    index++;
                    if (!visited[index]) count++;
                }
                visited[index] = true;
                th += (count - 1) * fact[i - 1];
            }
            ans.append(th);
        }

        System.out.println(ans);

    }

}