import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] lectures;
    static int maxLecture;

    static boolean recording(int size) {
        int count = 0;
        int curSize = 0;

        for (int lecture : lectures) {
            if (lecture > curSize) {
                curSize = size;
                count++;
            }

            curSize -= lecture;
        }

        return count <= M;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        lectures = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            lectures[i] = Integer.parseInt(st.nextToken());
            maxLecture = Math.max(maxLecture, lectures[i]);
        }

        int left = 0;
        int right = Integer.MAX_VALUE;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (mid < maxLecture || !recording(mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(left);
    }
}