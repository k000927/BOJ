import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n;
    static int l;

    static class Pond implements Comparable<Pond> {
        int start, end;

        Pond(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Pond o) {
            if (this.start != o.start)
                return this.start - o.start;
            else
                return this.end - o.end;
        }

    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        ArrayList<Pond> pondList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            pondList.add(new Pond(start, end));

        }

        Collections.sort(pondList);

        int ans = 0;
        int bridgeIndex = 0;
        Pond prev = new Pond(0,0);

        while (!pondList.isEmpty()) {
            Pond curr = pondList.remove(0);

            int end = curr.end;

            if (curr.end <= prev.end) continue;

            if (bridgeIndex < curr.start) bridgeIndex = curr.start;

            if(bridgeIndex >= end) continue;
            int length = end - bridgeIndex;
            int numOfWood = length%l == 0 ? length/l : length/l+1;
            ans += numOfWood;

            bridgeIndex += numOfWood * l;
        }

        System.out.println(ans);

    }

}
