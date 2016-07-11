package java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 * Given a binary tree, return the level order traversal of its nodes' values. 
 * (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
 * @author Marcus
 *
 */
public class BinaryTreeLevelOrderTraversal {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList();
		if (root == null) {
			return result;
		}

		LinkedList<TreeNode> q = new LinkedList();
		q.add(root);

		while (!q.isEmpty()) {
			LinkedList<TreeNode> tempQ = new LinkedList();
			ArrayList<Integer> rowResult = new ArrayList();
			while (!q.isEmpty()) {
				TreeNode node = q.remove();
				rowResult.add(node.val);
				if (node.left != null) {
					tempQ.add(node.left);
				}
				if (node.right != null) {
					tempQ.add(node.right);
				}
			}
			result.add(rowResult);
			q = tempQ;
		}
		return result;
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
