import java.io.*;
import java.util.*;

public class Main {
    static int n;

    static class File implements Comparable<File> {
        String name;
        HashMap<String, File> subFiles;

        File(String name) {
            this.name = name;
            subFiles = new HashMap<>();
        }

        public void putSubFiles(File subFile) {
            subFiles.put(subFile.name, subFile);
        }

        public File getSubFile(String name) {
            return subFiles.get(name);
        }

        @Override
        public int compareTo(File o) {
            return name.compareTo(o.name);
        }
    }

    static void print(File file, int level) {
        System.out.println(" ".repeat(level) + file.name);
        PriorityQueue<File> pq = new PriorityQueue<>(file.subFiles.values());
        while (!pq.isEmpty()) {
            print(pq.poll(), level + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        File rootFile = new File("root");

        File superFile = null;
        File subFile = null;
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            String[] split = str.split("\\\\");

            superFile = rootFile;
            for (String fileName : split) {
                subFile = superFile.getSubFile(fileName);
                if (subFile == null) {
                    subFile = new File(fileName);
                    superFile.putSubFiles(subFile);
                }
                superFile = subFile;
            }
        }

        PriorityQueue<File> pq = new PriorityQueue<>(rootFile.subFiles.values());

        while (!pq.isEmpty()) {
            print(pq.poll(), 0);
        }
    }
}