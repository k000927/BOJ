import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        HashMap<Integer, Integer> pillars = new HashMap<>();
        int max_h = -1;
        int start_pos = 1001;
        int end_pos = 0;
        ArrayList<Integer> idx = new ArrayList<>();

        for (int i = 1; i < 1001; i++) {
            pillars.put(i, 0);
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int pos = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());

            start_pos = Math.min(start_pos, pos);
            end_pos = Math.max(end_pos, pos);

            pillars.put(pos, height);

            if (max_h == height) {
                idx.add(pos);
            } else if (max_h < height) {
                max_h = height;
                idx.clear();
                idx.add(pos);
            }
        }

        Collections.sort(idx);

        int first_floor = idx.get(0);
        int last_floor = idx.get(idx.size() - 1);

        int height = pillars.get(start_pos);
        int ans = 0;

        for (int i = start_pos; i < first_floor; i++) {
            int cur_height = pillars.get(i);
            if (height < cur_height) height = cur_height;
            ans += height;
        }

        height = pillars.get(end_pos);
        for (int i = end_pos; i > last_floor; i--) {
            int cur_height = pillars.get(i);
            if (height < cur_height) height = cur_height;
            ans += height;
        }

        ans += (last_floor - first_floor + 1) * max_h;

        System.out.println(ans);
    }
}