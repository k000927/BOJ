import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long C = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        int mid = N / 2;
        int leftSize = mid;
        int rightSize = N - mid;

        ArrayList<Long>[] leftSums = new ArrayList[leftSize + 1];
        for (int i = 0; i <= leftSize; i++) leftSums[i] = new ArrayList<>();

        ArrayList<Long>[] rightSums = new ArrayList[rightSize + 1];
        for (int i = 0; i <= rightSize; i++) rightSums[i] = new ArrayList<>();

        int limL = 1 << leftSize;
        for (int mask = 0; mask < limL; mask++) {
            long sum = 0;
            int cnt = 0;
            for (int i = 0; i < leftSize; i++) {
                if ((mask & (1 << i)) != 0) {
                    sum += arr[i];
                    cnt++;
                }
            }
            if (sum <= C) leftSums[cnt].add(sum);
        }

        int limR = 1 << rightSize;
        for (int mask = 0; mask < limR; mask++) {
            long sum = 0;
            int cnt = 0;
            for (int i = 0; i < rightSize; i++) {
                if ((mask & (1 << i)) != 0) {
                    sum += arr[mid + i];
                    cnt++;
                }
            }
            if (sum <= C) rightSums[cnt].add(sum);
        }

        for (int i = 0; i <= rightSize; i++) {
            Collections.sort(rightSums[i]);
        }

        long answer = 0L;

        for (int k = 0; k <= N; k++) {
            int lmin = Math.max(0, k - rightSize);
            int lmax = Math.min(leftSize, k);
            for (int l = lmin; l <= lmax; l++) {
                int r = k - l;
                ArrayList<Long> L = leftSums[l];
                ArrayList<Long> R = rightSums[r];
                if (L.isEmpty() || R.isEmpty()) {
                    if (R.isEmpty()) {
                        if (r == 0) answer += L.size();
                    } else if (L.isEmpty()) {
                        if (l == 0) answer += R.size();
                    }
                    continue;
                }
                for (long sumL : L) {
                    long remain = C - sumL;
                    int cnt = upperBound(R, remain);
                    answer += cnt;
                }
            }
        }

        System.out.println(answer);
    }

    static int upperBound(ArrayList<Long> list, long key) {
        int l = 0, r = list.size() - 1, ans = 0;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (list.get(mid) <= key) {
                ans = mid + 1;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
}
