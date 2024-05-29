import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<String> ans = new ArrayList<>();

    static class node {
        String ttt;
        int turn;

        node(String ttt, int turn) {
            this.ttt = ttt;
            this.turn = turn;
        }
    }

    public static Boolean judge(String ttt) {
        if (ttt.charAt(0) != '.' && ttt.charAt(0) == ttt.charAt(1) && ttt.charAt(0) == ttt.charAt(2)) return true;
        if (ttt.charAt(3) != '.' && ttt.charAt(3) == ttt.charAt(4) && ttt.charAt(3) == ttt.charAt(5)) return true;
        if (ttt.charAt(6) != '.' && ttt.charAt(6) == ttt.charAt(7) && ttt.charAt(6) == ttt.charAt(8)) return true;
        if (ttt.charAt(0) != '.' && ttt.charAt(0) == ttt.charAt(3) && ttt.charAt(0) == ttt.charAt(6)) return true;
        if (ttt.charAt(1) != '.' && ttt.charAt(1) == ttt.charAt(4) && ttt.charAt(1) == ttt.charAt(7)) return true;
        if (ttt.charAt(2) != '.' && ttt.charAt(2) == ttt.charAt(5) && ttt.charAt(2) == ttt.charAt(8)) return true;
        if (ttt.charAt(0) != '.' && ttt.charAt(0) == ttt.charAt(4) && ttt.charAt(0) == ttt.charAt(8)) return true;
        if (ttt.charAt(2) != '.' && ttt.charAt(2) == ttt.charAt(4) && ttt.charAt(2) == ttt.charAt(6)) return true;
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String ttt = ".........";
        String[] XO = {"X", "O"};

        ArrayList<node> arr = new ArrayList<>();
        ArrayList<String> visited = new ArrayList<>();
        arr.add(new node(ttt, 0));

        while (!arr.isEmpty()) {
            node cur = arr.remove(0);

            String cur_ttt = cur.ttt;
            int turn = cur.turn;
            if (turn == 9) {
                ans.add(cur_ttt);
                continue;
            }

            for (int i = 0; i < 9; i++) {
                if (cur_ttt.charAt(i) != '.') continue;
                String next_ttt = cur_ttt.substring(0, i) + XO[turn % 2] + cur_ttt.substring(i + 1);
                if (visited.contains(next_ttt)) continue;
                if (judge(next_ttt)) {
                    ans.add(next_ttt);
                } else {
                    arr.add(new node(next_ttt, turn + 1));
                }
                visited.add(next_ttt);
            }
        }

        String str = "";
        while (!(str = br.readLine()).equals("end")) {
            if (ans.contains(str)) bw.write("valid\n");
            else bw.write("invalid\n");
        }

        bw.flush();
    }
}