package array.medium;

public class ConstructBinaryTreefromPreorderandInorderTraversal {

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		TreeNode root = helper(preorder, 0, preorder.length - 1, inorder, 0,
				inorder.length - 1);
		return root;
	}

	private TreeNode helper(int[] preorder, int prestart, int preend,
			int[] inorder, int instart, int inend) {
		if (instart > inend)
			return null;
		int position = findPreorderElementPositionInInorder(preorder[prestart],
				inorder, instart, inend);
		int numOfElementsAtLeft = position - instart;
		TreeNode node = new TreeNode(preorder[prestart]);
		node.left = helper(preorder, prestart + 1, prestart
				+ numOfElementsAtLeft, inorder, instart, instart
				+ numOfElementsAtLeft - 1);
		node.right = helper(preorder, prestart + numOfElementsAtLeft + 1,
				preend, inorder, position + 1, inend);
		return node;
	}

	private int findPreorderElementPositionInInorder(int element,
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
