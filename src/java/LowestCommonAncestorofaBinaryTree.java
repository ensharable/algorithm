package java;

public class LowestCommonAncestorofaBinaryTree {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || root == p || root == q) {
			return root;
		}

		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);

		if (left == null) {
			// it is not in the left side, so it may in the right side. (right
			// can be null too, but it is OK to return null)
			return right;
		} else if (right == null) {
			// it is not in the right side, so it may in the left side. (left
			// can be null too, but it is OK to return null)
			return left;
		} else {
			// left and right are both not null. That means, both side has p or
			// q; so current root is the answer
			return root;
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
