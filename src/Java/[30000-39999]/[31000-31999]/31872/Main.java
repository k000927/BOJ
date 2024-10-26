import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 강의 개수
        int k = Integer.parseInt(st.nextToken()); // 순간이동 횟수

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 오름차순으로 정렬
        Arrays.sort(arr);

        // 각 강의실 마다 이동해야되는 거리를 저장
        int[] times = new int[n];
        int start = 0; // 혁준이 현재 위치

        for (int i = 0; i < n; i++) {
            times[i] = arr[i] - start;
            start = arr[i];
        }

        // 거리들 오름차순 정렬
        Arrays.sort(times);

        int count = 0;

        // 순간이동 횟수만큼 먼 거리는 제거
        for (int i = 0; i < n - k; i++) {
            count += times[i];
        }

        bw.write(Integer.toString(count));
        bw.flush();
        bw.close();
        br.close();
    }
}