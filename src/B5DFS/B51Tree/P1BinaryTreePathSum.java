package B5DFS.B51Tree;

/**
 * 给定二叉树中是否存在一条根到页的路径，使路径和为S
 * @author CodeCoderCoding
 */
public class P1BinaryTreePathSum {
    public static boolean hasPath(TreeNode root, int sum) {
        if (root == null)
            return false;

        //如果当前节点是叶子结点并且它的值等于和sum，那么我们便找到了一条路径和等于sum
        if (root.val == sum && root.left == null && root.right == null)
            return true;

        // 递归调用左子树和右子树
        // 如果左右子树的任一子树返回true，那么将返回true
        return hasPath(root.left, sum - root.val) || hasPath(root.right, sum - root.val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println("Tree has path: " + P1BinaryTreePathSum.hasPath(root, 23));
        System.out.println("Tree has path: " + P1BinaryTreePathSum.hasPath(root, 16));
    }
}
