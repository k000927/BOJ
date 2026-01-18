import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] arrA, arrB;

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine()) / 2;
        arrA = new int[n];
        arrB = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arrA[i] = Integer.parseInt(st.nextToken());
            arrB[i] = Integer.parseInt(st.nextToken());
            br.readLine();
        }

        System.out.println(Math.max(solution(arrA, n), solution(arrB, n)));
    }

    static int solution(int[] arr, int n) {
        int tmp = min(arr);
        if (tmp != 0) {
            for (int i = 0; i < n; i++) {
                arr[i] -= tmp;
            }
        }

        int[] res = new int[max(arr) + 1];
        for (int i = 0; i < n - 1; i++) {
            res[Math.min(arr[i], arr[i + 1])] += 1;
            res[Math.max(arr[i], arr[i + 1])] -= 1;
        }

        res[Math.min(arr[0], arr[n - 1])] += 1;
        res[Math.max(arr[0], arr[n - 1])] -= 1;

        for (int i = 1; i < res.length - 1; i++) {
            res[i] += res[i - 1];
        }

        return max(res);
    }

    static int min(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int num : arr) {
            if (min > num) {
                min = num;
            }
        }
        return min;
    }

    static int max(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int num : arr) {
            if (max < num) {
                max = num;
            }
        }
        return max;
    }
}