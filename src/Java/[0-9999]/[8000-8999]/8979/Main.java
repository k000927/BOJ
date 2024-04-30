import java.io.*;
import java.util.*;

public class Main {
    static class Nation {
        int n;
        int gold;
        int silver;
        int bronze;

        Nation(int n, int gold, int silver, int bronze) {
            this.n = n;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }

        public Boolean compareTo(Nation n) {
            if (n.gold == this.gold && n.silver == this.silver && n.bronze == this.bronze) {
                return false;
            } else if (n.gold == this.gold && n.silver == this.silver) {
                return n.bronze > this.bronze;
            } else if (n.gold == this.gold) {
                return n.silver > this.silver;
            } else return n.gold > this.gold;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Nation[] nations = new Nation[n];
        Nation target = null;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());
            nations[i] = new Nation(num, gold, silver, bronze);
            if (num == k) {
                target = nations[i];
            }
        }
        int ans = 1;
        for (int i = 0; i < n; i++) {
            if (target.compareTo(nations[i]) && nations[i].n != k) {
                ans++;
            }
        }
        System.out.println(ans);
    }
}