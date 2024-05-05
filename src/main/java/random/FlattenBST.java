package random;

public class FlattenBST {

    public static void main(String[] args) {
        TreeNode root5 = new TreeNode(5);
        TreeNode node8  = new TreeNode(8);
        TreeNode node7 = new TreeNode(7);
        TreeNode node9 = new TreeNode(9);

        root5.right = node8;
        node8.left = node7;
        node8.right = node9;

        TreeNode result = new FlattenBST().flatten(root5);
        System.out.println(result);
    }

    public TreeNode flatten(TreeNode node) {
        if (node == null) return null;
        if (node.left == null && node.right == null) return node;

        TreeNode left = flatten(node.left);
        TreeNode right = flatten(node.right);

        node.left = null;

        TreeNode temp = left;
        while (temp != null && temp.right != null) {
            temp = temp.right;
        }

        if (temp != null)
            temp.right = node;

        node.right = right;

        return (left != null) ? left : node;
    }

    private static class TreeNode{
       private int data;
       private TreeNode left;
       private TreeNode right;

       public TreeNode(int data) {
           this.data = data;
       }

       public int getData() {
           return data;
       }

       public void setData(int data) {
           this.data = data;
       }

       public TreeNode getLeft() {
           return left;
       }

       public void setLeft(TreeNode left) {
           this.left = left;
       }

       public TreeNode getRight() {
           return right;
       }

       public void setRight(TreeNode right) {
           this.right = right;
       }
   }


}
