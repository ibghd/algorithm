package leetChallenge;

import java.util.LinkedList;
import java.util.Queue;

public class LeetChallenge {

	/**
	 * 
	 * Given a non-negative integer num, repeatedly add all its digits until the
	 * result has only one digit. For example: Given num = 38, the process is like:
	 * 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
	 *
	 * @param num
	 * @return
	 */
	public static int addDigits(int num) {
		return num % 9;
	}

	/**
	 * 
	 * Hamming distance
	 * 
	 * @param args
	 */
	public static int hammingDistance(int x, int y) {
		int val = 0;
		int z = (x ^ y) & 0xFF;
		while (z != 0) {
			if ((z & 1) == 1) {
				val++;
			}
			z /= 2;
		}
		return val;
	}

	/**
	 * Given a binary tree, return the level order traversal of its nodes' values
	 * 
	 * @return
	 */

	public class treeNode {
		int value;
		treeNode left;
		treeNode right;

		treeNode(int x) {
			this.value = x;
		}
		// isEmpty(){return this.value }
		// isNode(){return x}
	}

	public static LinkedList<Integer> binaryTreeLevelOrder(treeNode tree) {
		LinkedList<Integer> result = new LinkedList<Integer>();
		Queue<treeNode> queue = new LinkedList<treeNode>();
		queue.add(tree);
		while (!queue.isEmpty()) {
			treeNode t = queue.remove();
			result.addLast(t.value);
			queue.add(t.left);
			queue.add(t.right);
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(addDigits(38));
		System.out.println(hammingDistance(1, 6));

	}

}
