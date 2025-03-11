import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    static class Military implements Comparable<Military> {
        int year;
        int month;
        boolean flag;

        Military(int year, int month, boolean flag) {
            this.year = year;
            this.month = month;
            this.flag = flag;
        }

        public int compareTo(Military m) {
            if (year == m.year && month == m.month) {
                if (flag && m.flag) return 0;
                else if(flag && !m.flag) return -1;
                else if(!flag && m.flag) return 1;
                else return 0;
            } else if (year == m.year) {
                return Integer.compare(month, m.month);
            }
            return Integer.compare(year, m.year);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(year).append("-").append(String.format("%02d", month));
            return sb.toString();
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Military> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] date = br.readLine().split(" ");
            String[] start = date[0].split("-");
            String[] end = date[1].split("-");

            list.add(new Military(Integer.parseInt(start[0]), Integer.parseInt(start[1]), true));
            list.add(new Military(Integer.parseInt(end[0]), Integer.parseInt(end[1]), false));
        }

        Collections.sort(list);

        int maxSoldiers = 0;
        int curSoldiers = 0;
        String ans = "";

        for (int i = 0; i < N * 2; i++) {
            Military curr = list.get(i);

            if (curr.flag) {
                curSoldiers++;

                if (maxSoldiers < curSoldiers) {
                    ans = curr.toString();
                    maxSoldiers = curSoldiers;
                }

            } else curSoldiers--;
        }

        System.out.println(ans);
    }
}