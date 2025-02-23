import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int k;

    static int[] cheapestFriend;
    static int[] A;

    static int find(int x) {
        if (cheapestFriend[x] == x)
            return x;
        else return cheapestFriend[x] = find(cheapestFriend[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (A[x] < A[y]) {
            cheapestFriend[y] = x;
        } else if (A[x] > A[y]) {
            cheapestFriend[x] = y;
        } else {
            if (x < y) cheapestFriend[y] = x;
            else cheapestFriend[x] = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        cheapestFriend = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            cheapestFriend[i] = i;
        }
        A = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            union(v, w);
        }

        int cost = 0;
        HashSet<Integer> costSet = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            costSet.add(find(i));
        }

        for (Integer i : costSet) {
            cost += A[i];
        }

        if(cost <= k) System.out.println(cost);
        else System.out.println("Oh no");
    }
}