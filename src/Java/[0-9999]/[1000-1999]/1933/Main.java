import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
	static final StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
	static StringBuilder ans = new StringBuilder();

	static class Node implements Comparable<Node> {
		int num, x, y;
		boolean flag;

		Node(int num, int x, int y, boolean flag) {
			this.num = num;
			this.x = x;
			this.y = y;
			this.flag = flag;
		}

		@Override
		public int compareTo(Node n) {
			if (this.x < n.x)
				return -1;
			else if (this.x == n.x) {
				if (this.flag && n.flag)
					return Integer.compare(n.y, this.y);
				else if (!this.flag && n.flag)
					return 1;
				else if (this.flag && !n.flag)
					return -1;
				else
					return Integer.compare(this.y, n.y);
			} else
				return 1;

		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		int n = nextInt();

		Node[] nodeList = new Node[n * 2];

		for (int i = 0; i < n; i++) {
			int leftTop = nextInt();
			int height = nextInt();
			int rightTop = nextInt();

			nodeList[i * 2] = new Node(i, leftTop, height, true);
			nodeList[i * 2 + 1] = new Node(i, rightTop, height, false);
		}

		Arrays.sort(nodeList);

		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
		pq.add(0);

		int curMaxHeight = 0;
		for (int i = 0; i < n * 2; i++) {
			Node curNode = nodeList[i];

			if (curNode.flag) {
				if (curNode.y > curMaxHeight) {
					ans.append(curNode.x).append(" ").append(curNode.y).append(" ");
					curMaxHeight = curNode.y;
				}
				pq.add(curNode.y);
			} else {
				pq.remove(curNode.y);

				if (curNode.y == curMaxHeight) {
					int nextHeight = pq.peek();

					if (curNode.y > nextHeight) {
						ans.append(curNode.x).append(" ").append(nextHeight).append(" ");
						curMaxHeight = nextHeight;
					}
				}
			}
		}

		System.out.println(ans);
	}

	private static int nextInt() throws IOException {
		st.nextToken();
		return (int) st.nval;
	}
}
