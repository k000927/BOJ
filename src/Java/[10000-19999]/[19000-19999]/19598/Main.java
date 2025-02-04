import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static StringTokenizer st;
    static List<Meeting> meetings;
    static int ans = 0;

    static class Meeting implements Comparable<Meeting> {
        int time;
        boolean flag;

        Meeting(int time, boolean flag) {
            this.time = time;
            this.flag = flag;
        }

        public int compareTo(Meeting o) {
            if(this.time != o.time) {
                return Integer.compare(this.time, o.time);
            }
            else return Boolean.compare(this.flag, o.flag);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        meetings = new ArrayList<>();

        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            meetings.add(new Meeting(start, true));
            meetings.add(new Meeting(end, false));
        }

        Collections.sort(meetings);

        ArrayDeque<Object> meetingStack = new ArrayDeque<>();
        for (Meeting meeting : meetings) {
            if (meeting.flag) {
                meetingStack.push(meeting.time);
                ans = Math.max(ans, meetingStack.size());
            } else {
                meetingStack.pop();
            }
        }

        System.out.println(ans);
    }
}