import javax.swing.text.StyledEditorKit;
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] gear = new String[4];
        for (int i = 0; i < 4; i++) {
            gear[i] = br.readLine();
        }
        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken());
            int[] rotate = new int[4];
            rotate[num] = dir;
            for (int j = num + 1; j < 4; j++) {
                if (gear[j].charAt(6) != gear[j - 1].charAt(2)) {
                    rotate[j] = rotate[j - 1] * -1;
                } else break;
            }
            for (int j = num - 1; j >= 0; j--) {
                if (gear[j].charAt(2) != gear[j + 1].charAt(6)) {
                    rotate[j] = rotate[j + 1] * -1;
                } else break;
            }
            for (int gear_idx = 0; gear_idx < 4; gear_idx++) {
                if (rotate[gear_idx] == 0) {
                    continue;
                }
                if (rotate[gear_idx] == 1) {
                    gear[gear_idx] = gear[gear_idx].charAt(7) + gear[gear_idx].substring(0, 7);
                } else {
                    gear[gear_idx] = gear[gear_idx].substring(1) + gear[gear_idx].charAt(0);
                }
            }
        }
        int ans = 0;
        if (gear[0].charAt(0) == '1') ans += 1;
        if (gear[1].charAt(0) == '1') ans += 2;
        if (gear[2].charAt(0) == '1') ans += 4;
        if (gear[3].charAt(0) == '1') ans += 8;
        System.out.println(ans);
    }
}