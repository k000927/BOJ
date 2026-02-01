import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static Map<String, Integer> extMap;

    static class Ext implements Comparable<Ext> {
        String name;
        int count;

        Ext(String name, int count) {
            this.name = name;
            this.count = count;
        }

        @Override
        public int compareTo(Ext o) {
            return this.name.compareTo(o.name);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        extMap = new HashMap<>();
        N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            String file = br.readLine();
            String ext = file.substring(file.lastIndexOf(".") + 1);

            if (!extMap.containsKey(ext)) {
                extMap.put(ext, 1);
            } else {
                extMap.put(ext, extMap.get(ext) + 1);
            }
        }

        PriorityQueue<Ext> pq = new PriorityQueue<>();
        for (String ext : extMap.keySet()) {
            int count = extMap.get(ext);
            pq.add(new Ext(ext, count));
        }

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Ext cur = pq.poll();
            sb.append(cur.name).append(' ').append(cur.count).append("\n");
        }
        System.out.print(sb);
    }
}
