import java.io.*;
import java.util.*;

public class Main {

    static class Lecture implements Comparable<Lecture> {
        int time;
        boolean isStart;

        Lecture(int time, boolean isStart) {
            this.time = time;
            this.isStart = isStart;
        }

        @Override
        public int compareTo(Lecture o) {
            if (this.time == o.time) {
                if (this.isStart == o.isStart)
                    return 0;
                else if (this.isStart)
                    return 1;
                else
                    return -1;
            }

            return this.time - o.time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Queue<Lecture> lecturePQ = new PriorityQueue<>();
        int start, end;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());

            lecturePQ.add(new Lecture(start, true));
            lecturePQ.add(new Lecture(end, false));
        }

        int maxSize = 0;
        int curSize = 0;
        Lecture lecture;
        while (!lecturePQ.isEmpty()) {
            lecture = lecturePQ.poll();

            if (lecture.isStart) {
                curSize++;
                maxSize = Math.max(maxSize, curSize);
            } else {
                curSize--;
            }
        }

        System.out.println(maxSize);
    }
}