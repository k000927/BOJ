import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer> number = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            number.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(number);

        int ans = 0;

        for (int i = 0; i < n; i++) {
            int curNum = number.get(i);

            int start = 0;
            int end = n - 1;

            while (start < end) {
                if (start == i) start++;
                else if (end == i) end--;
                else {
                    int sum = number.get(start) + number.get(end);
                    if (sum == curNum) {
                        ans++;
                        break;
                    } else if (sum < curNum) start++;
                    else end--;
                }
            }
        }

        System.out.println(ans);
    }
}