import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[] sensors;
    static List<Center> centers;

    static class Center {
        int start, end;

        Center(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        sensors = new int[N];
        centers = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sensors[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(sensors);

        int sensor, totalLength = 0;
        int removeCenter, minDist, curDist;
        for (int i = 0; i < N; i++) {
            sensor = sensors[i];

            centers.add(new Center(sensor, sensor));

            if (centers.size() > K) {
                minDist = Integer.MAX_VALUE;
                removeCenter = 0;

                for (int c = 0; c < K; c++) {
                    curDist = centers.get(c + 1).start - centers.get(c).end;
                    if (curDist < minDist) {
                        minDist = curDist;
                        removeCenter = c;
                    }
                }

                centers.get(removeCenter).end = centers.get(removeCenter + 1).end;
                centers.remove(removeCenter + 1);
                totalLength += minDist;
            }

        }

        System.out.println(totalLength);
    }
}