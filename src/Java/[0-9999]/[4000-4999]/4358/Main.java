import java.io.*;
import java.util.*;

public class Main {
    static int size;
    static Map<String, Integer> treeMap;
    static Queue<TreeInfo> treeQueue;

    static class TreeInfo implements Comparable<TreeInfo> {
        String name;
        double ratio;

        TreeInfo(String name, double ratio) {
            this.name = name;
            this.ratio = ratio;
        }

        @Override
        public int compareTo(TreeInfo o) {
            return name.compareTo(o.name);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        treeMap = new TreeMap<>();

        String tree = "";
        while ((tree = br.readLine()) != null) {
            size++;
            if (treeMap.containsKey(tree)) {
                treeMap.put(tree, treeMap.get(tree) + 1);
            } else {
                treeMap.put(tree, 1);
            }
        }

        treeQueue = new PriorityQueue<>();
        for (String treeName : treeMap.keySet()) {
            double ratio = ((double) treeMap.get(treeName) / size) * 100;
            treeQueue.add(new TreeInfo(treeName, ratio));
        }

        StringBuilder ans = new StringBuilder();
        while (!treeQueue.isEmpty()) {
            TreeInfo treeInfo = treeQueue.poll();
            ans.append(treeInfo.name).append(' ').append(String.format("%.4f", treeInfo.ratio)).append("\n");
        }

        System.out.print(ans);
    }
}