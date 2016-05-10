package array.medium;

public class ConstructBinaryTreefromInorderandPostorderTraversal {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		TreeNode root = helper(inorder, 0, inorder.length - 1, postorder, 0,
				postorder.length - 1);
		return root;
	}

	private TreeNode helper(int[] inorder, int instart, int inend,
			int[] postorder, int poststart, int postend) {
		if (instart > inend)
			return null;
		int position = findPostorderElementPositionInInorder(
				postorder[postend], inorder, instart, inend);
		int numOfRightChildren = inend - position;
		TreeNode node = new TreeNode(postorder[postend]);
		node.right = helper(inorder, position + 1, inend, postorder, postend
				- numOfRightChildren, postend - 1);
		node.left = helper(inorder, instart, position - 1, postorder,
				poststart, postend - numOfRightChildren - 1);
		return node;
	}

	private int findPostorderElementPositionInInorder(int element,
			int[] inorder, int instart, int inend) {
		for (int i = instart; i <= inend; i++)
			if (inorder[i] == element)
				return i;
		return -1;
	}

	private class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}
