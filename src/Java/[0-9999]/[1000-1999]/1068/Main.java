import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main {
	static final StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

	static class Node {
		int childNum;
		int[] child;

		Node() {
			childNum = 0;
			child = new int[50];
		}
	}

	static int n;
	static Node[] tree;
	static int root;
	static int removedNode;

	static int getLeaf(int nodeIndex) {
		Node curNode = tree[nodeIndex];

		if (nodeIndex == removedNode)
			return 0;

		if (curNode.childNum == 0)
			return 1;

		int childLeaf = 0;

		for (int i = 0; i < curNode.childNum; i++) {
			childLeaf += getLeaf(curNode.child[i]);
		}

		return childLeaf == 0 ? 1 : childLeaf;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		n = nextInt();
		tree = new Node[n];

		for (int i = 0; i < n; i++) {
			tree[i] = new Node();
		}

		for (int nodeIndex = 0; nodeIndex < n; nodeIndex++) {
			int parentNode = nextInt();

			if (parentNode == -1)
				root = nodeIndex;
			else {
				tree[parentNode].child[tree[parentNode].childNum++] = nodeIndex;
			}
		}

		removedNode = nextInt();
		tree[removedNode].childNum = 0;

		System.out.println(getLeaf(root));
	}

	private static int nextInt() throws IOException {
		st.nextToken();
		return (int) st.nval;
	}
}
