import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] l = br.readLine().split(" ");
        int dummyCount = Integer.parseInt(l[1]);

        boolean result = true;

        for (int i = 0; i < dummyCount; i++) {
            int c = Integer.parseInt(br.readLine());
            String[] strs = br.readLine().split(" ");
            int preVal = 200_001;
            for (int j = 0; j < c; j++) {
                if (Integer.parseInt(strs[j]) > preVal) {
                    result = false;
                }
                preVal = Integer.parseInt(strs[j]);
            }
        }

        if (result) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

    }
}