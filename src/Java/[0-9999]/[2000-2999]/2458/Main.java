import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
 * bfs 돌면서 하기로...
 */
public class Main {
	static int T;
	static int n;
	static int m;
	static ArrayList<Student> students;
	static int[][] tallAndShort; // 0: 자기보다 큰 사람, 1: 자기보다 작은 사람
	static boolean[] visited;

	static class Student {
		int num;
		ArrayList<Student> taller;
		ArrayList<Student> shorter;

		Student(int num) {
			this.num = num;
			taller = new ArrayList<>();
			shorter = new ArrayList<>();
		}
	}

	static void updateTaller(Student stu) {
		visited = new boolean[n + 1];

		List<Student> studentQueue = new ArrayList<>();
		visited[stu.num] = true;
		studentQueue.add(stu);

		int cnt = 0;
		while (!studentQueue.isEmpty()) {
			Student curStu = studentQueue.remove(0);

			for (Student nextStu : curStu.taller) {
				if (visited[nextStu.num])
					continue;

				cnt++;
				visited[nextStu.num] = true;
				studentQueue.add(nextStu);
			}
		}

		tallAndShort[stu.num][0] = cnt;
	}

	static void updateShorter(Student stu) {
		visited = new boolean[n + 1];

		List<Student> studentQueue = new ArrayList<>();
		visited[stu.num] = true;
		studentQueue.add(stu);

		int cnt = 0;
		while (!studentQueue.isEmpty()) {
			Student curStu = studentQueue.remove(0);

			for (Student nextStu : curStu.shorter) {
				if (visited[nextStu.num])
					continue;

				cnt++;
				visited[nextStu.num] = true;
				studentQueue.add(nextStu);
			}
		}

		tallAndShort[stu.num][1] = cnt;
	}

	static int getAnswer() {
		int numOfStu = 0;

		for (int i = 1; i <= n; i++) {
			if (tallAndShort[i][0] + tallAndShort[i][1] + 1 == n)
				numOfStu++;
		}

		return numOfStu;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

			n = Integer.parseInt(st.nextToken().trim());
			m = Integer.parseInt(st.nextToken().trim());

			students = new ArrayList<>();
			for (int i = 0; i <= n; i++) {
				students.add(new Student(i));
			}
			tallAndShort = new int[n + 1][2];

			int a, b;
			Student shorter, taller;
			for (int in = 0; in < m; in++) {
				st = new StringTokenizer(br.readLine().trim());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());

				shorter = students.get(a);
				taller = students.get(b);

				shorter.taller.add(taller);
				taller.shorter.add(shorter);
			}

			for (int studi = 1; studi <= n; studi++) {
				Student curStu = students.get(studi);
				updateShorter(curStu);
				updateTaller(curStu);
			}

		System.out.println(getAnswer());
	}

}
