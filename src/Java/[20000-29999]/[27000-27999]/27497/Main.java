import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<String> ops = new Stack<>();
        Deque<String> ans = new ArrayDeque<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String op = br.readLine();
            if (op.startsWith("1") || op.startsWith("2")) {
                ops.push(op);
            } else {
                if(ops.empty()) continue;
                ops.pop();
            }
        }

        for (String op : ops) {
            if (op.startsWith("1")) {
                ans.addLast(op.split(" ")[1]);
            }
            else{
                ans.addFirst(op.split(" ")[1]);
            }
        }

        if(ans.isEmpty()) System.out.println(0);
        else {
            for (String an : ans) {
                bw.write(an);
            }
        }
        bw.flush();
        bw.close();
    }
}
