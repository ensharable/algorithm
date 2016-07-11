package java;

import java.util.ArrayList;
import java.util.List;


public class BinaryTreePaths {
	private List<String> res;

	public List<String> binaryTreePaths(TreeNode root) {
		res = new ArrayList<String>();
		if (root == null) {
			return res;
		}
		String s = root.val + "";
		// handle the rootNode, we can handle it using a flag (slower)
		if (root.left == null && root.right == null) {
			res.add(s);
			return res;
		}
		if (root.left != null) {
			travel(root.left, s);
		}
		if (root.right != null) {
			travel(root.right, s);
		}

		return res;
	}

	private void travel(TreeNode node, String s) {
		s = s + "->" + node.val;
		if (node.left == null && node.right == null) {
			res.add(s);
			return;
		}
		if (node.left != null) {
			travel(node.left, s);
		}
		if (node.right != null) {
			travel(node.right, s);
		}
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}
