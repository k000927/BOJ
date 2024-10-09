import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int k;
    static StringTokenizer st;

    static class Node implements Comparable<Node> {
        String name;
        HashMap<String, Node> childrenNode;

        Node(String name) {
            this.name = name;
            childrenNode = new HashMap<>();
        }

        public void addChild(Node child) {
            childrenNode.put(child.name, child);
        }

        @Override
        public int compareTo(Node o) {
            return name.compareTo(o.name);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return Objects.equals(name, node.name);
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(name);
        }
    }

    static void print(int level, Node node) {
        System.out.print("-".repeat(level*2));
        System.out.println(node.name);

        List<Node> nodes = new ArrayList<>(node.childrenNode.values());
        Collections.sort(nodes);

        for (Node n : nodes) {
            print(level + 1, n);
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());


        Node rootNode = new Node("root");

        Node parentNode = null;
        Node childNode = null;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());

            parentNode = rootNode;

            for (int j = 0; j < k; j++) {
                String name = st.nextToken();
                if (!parentNode.childrenNode.containsKey(name)) {
                    childNode = new Node(name);
                    parentNode.childrenNode.put(name, childNode);
                } else {
                    childNode = parentNode.childrenNode.get(name);
                }
                parentNode = childNode;
            }
        }

        List<Node> nodes = new ArrayList<>(rootNode.childrenNode.values());
        Collections.sort(nodes);

        for (Node node : nodes) {
            print(0, node);
        }
    }
}