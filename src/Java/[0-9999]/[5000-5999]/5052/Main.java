import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder ans = new StringBuilder();
    static String[] numbers;
    static int n;

    static class Node {
        boolean data;
        Node[] child;

        Node() {
            child = new Node[10];
        }
    }

    static Node root;

    static boolean insert() {
        for (int i = 0; i < n; i++) {
            String curNum = numbers[i];
            Node curNode = root;

            for(char c : curNum.toCharArray()) {
                if(curNode.child[c - '0'] == null){
                    curNode.child[c - '0'] = new Node();
                }
                curNode = curNode.child[c - '0'];

                if(curNode.data) return false;
            }

            curNode.data = true;
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        for (int t = 0; t < tc; t++) {
            n = Integer.parseInt(br.readLine());

            numbers = new String[n];
            for (int i = 0; i < n; i++) {
                numbers[i] = br.readLine();
            }
            Arrays.sort(numbers);

            root = new Node();
            ans.append(insert() ? "YES" : "NO").append("\n");
        }

        System.out.println(ans);
    }
}