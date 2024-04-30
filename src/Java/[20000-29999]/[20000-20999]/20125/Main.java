import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Character[][] cookie = new Character[n][n];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                cookie[i][j] = line.charAt(j);
            }
        }

        int heart_x = -1;
        int heart_y = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (cookie[i][j] == '_') continue;
                else {
                    if (i - 1 < 0 || cookie[i - 1][j] == '_') continue;
                    if (j - 1 < 0 || cookie[i][j - 1] == '_') continue;
                    if (i + 1 >= n || cookie[i + 1][j] == '_') continue;
                    if (j + 1 >= n || cookie[i][j + 1] == '_') continue;
                    heart_x = i;
                    heart_y = j;
                }
            }
        }
        int left_arm = 1;
        int right_arm = 1;
        int left_leg = 1;
        int right_leg = 1;
        int waist = 1;

        while (heart_y - left_arm >= 0 && cookie[heart_x][heart_y - left_arm] == '*') left_arm++;
        while (heart_y + right_arm < n && cookie[heart_x][heart_y + right_arm] == '*') right_arm++;
        while (cookie[heart_x + waist][heart_y] == '*') waist++;
        waist--;
        while (heart_x + waist + left_leg < n && cookie[heart_x + waist + left_leg][heart_y - 1] == '*') left_leg++;
        while (heart_x + waist + right_leg < n && cookie[heart_x + waist + right_leg][heart_y + 1] == '*') right_leg++;

        System.out.println((heart_x + 1) + " " + (heart_y + 1));
        System.out.printf("%d %d %d %d %d", left_arm - 1, right_arm - 1, waist, left_leg - 1, right_leg - 1);
    }
}