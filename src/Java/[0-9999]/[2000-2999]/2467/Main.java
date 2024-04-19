import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Long[] numbers = new Long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Long.parseLong(st.nextToken());
        }

        Long near_zero = 2000000000L;
        Long ans_first = -1L;
        Long ans_last = -1L;
        for (int i = 0; i < n; i++) {
            Long curNum = numbers[i];
            int start = 0;
            int end = n - 1;
            int mid;
            while (start <= end) {
                mid = (start + end) / 2;
                Long temp = curNum + numbers[mid];
                if (temp > 0) {
                    if (mid == i) {
                        end = mid - 1;
                        continue;
                    }
                    if (abs(temp) < near_zero) {
                        near_zero = abs(temp);
                        ans_first = min(curNum, numbers[mid]);
                        ans_last = max(curNum, numbers[mid]);
                    }
                    end = mid - 1;
                } else {
                    if (mid == i) {
                        start = mid + 1;
                        continue;
                    }
                    if (abs(temp) < near_zero) {
                        near_zero = abs(temp);
                        ans_first = min(curNum, numbers[mid]);
                        ans_last = max(curNum, numbers[mid]);
                    }
                    start = mid + 1;
                }
            }
        }
        System.out.println(ans_first + " " + ans_last);
    }
}