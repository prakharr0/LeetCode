package leetcode.random;

/**
 * LeetCode 404: Sum of left leaves of a tree

 * Given the root of a binary tree, return the sum of all left leaves.
 * A leaf is a node with no children. A left leaf is a leaf that is the left
 * child of another node.
 *
 * @author rathi.prakhar@outlook.com
 */
public class SumOfLeftLeaves {

    /**
     * Traverse the entire tree, at every node, need to find a left leaf
     * return the value of left leaf when found
     * at root, add all left leaves
     */
    public int sumOfLeftLeaves(TreeNode root) {
        return sumOfLeftLeaves(root, "root");
    }

    private int sumOfLeftLeaves(TreeNode node, String type) {
        if (node == null) return 0;

        if (node.left == null && node.right == null && type.equals("left")) {
            return node.val;
        }

        int left = sumOfLeftLeaves(node.left, "left");
        int right = sumOfLeftLeaves(node.right, "right");

        return left + right;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
