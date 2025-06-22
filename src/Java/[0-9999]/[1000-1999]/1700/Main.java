import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[] works;
    static Set<Integer> multi;

    static int getOptPlug(int t) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int plug : multi) {
            map.put(plug, Integer.MAX_VALUE);
        }

        for (int i = t; i < K; i++) {
            if (multi.contains(works[i]))
                map.put(works[i], Math.min(map.get(works[i]), i));
        }

        int ret = 0, maxT = 0;
        for (Integer i : map.keySet()) {
            if(map.get(i) > maxT){
                ret = i;
                maxT = map.get(i);
            }
        }
        return ret;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        multi = new HashSet<>();
        works = new int[K];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            works[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;
        for (int i = 0; i < K; i++) {
            if (multi.contains(works[i]))
                continue;
            else if (multi.size() == N) {
                multi.remove(getOptPlug(i));
                ans++;
            }
            multi.add(works[i]);
        }

        System.out.println(ans);
    }
}