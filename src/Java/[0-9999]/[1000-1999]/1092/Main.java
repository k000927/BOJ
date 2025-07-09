import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    static int N, M, movedBox;
    static ArrayList<Integer> crane, box;
    static boolean[] isMoved;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        crane = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            crane.add(Integer.parseInt(st.nextToken()));
        }
        crane.sort(Collections.reverseOrder());

        M = Integer.parseInt(br.readLine());
        box = new ArrayList<>();
        isMoved = new boolean[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            box.add(Integer.parseInt(st.nextToken()));
        }
        box.sort(Collections.reverseOrder());

        if (crane.get(0) < box.get(0)) {
            System.out.println(-1);
            System.exit(0);
        }

        int ans = 0;
        while(!box.isEmpty()){
            ans++;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < box.size(); j++) {
                    if(crane.get(i) >= box.get(j)){
                        box.remove(j);
                        break;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}