import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static Employee[] employees;
    static int[] dp;

    static class Employee implements Comparable<Employee> {
        int num, level;
        List<Employee> children;
        Employee parent;

        Employee(int num) {
            this.num = num;
            children = new ArrayList<>();
        }

        public void setParent(Employee parent) {
            this.parent = parent;
        }

        public void addChild(Employee child) {
            this.children.add(child);
        }

        @Override
        public int compareTo(Employee e) {
            return Integer.compare(e.level, this.level);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        dp = new int[N];
        employees = new Employee[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            employees[i] = new Employee(i);
            int parent = Integer.parseInt(st.nextToken());
            if (parent != -1) {
                employees[parent].addChild(employees[i]);
                employees[i].setParent(employees[parent]);
            }
        }

        employees[0].level = 0;
        Queue<Employee> levelQueue = new LinkedList<>();
        Queue<Employee> queue = new PriorityQueue<>();
        levelQueue.add(employees[0]);

        while (!levelQueue.isEmpty()) {
            Employee curr = levelQueue.poll();
            for (Employee child : curr.children) {
                child.level = curr.level + 1;
                levelQueue.add(child);
                if (child.children.isEmpty()) {
                    queue.add(child);
                }
            }
        }

        while (true) {
            Employee curr = queue.poll();

            if (curr.parent == null) {
                System.out.println(dp[curr.num]);
                break;
            }

            if (curr.children.isEmpty()) {
                dp[curr.num] = 1;
            }

            dp[curr.parent.num] += dp[curr.num];
            queue.add(curr.parent);
        }
    }
}
