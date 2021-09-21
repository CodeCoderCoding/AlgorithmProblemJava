package B5DFS.B51Tree;

import java.util.*;
/**
 * 给定二叉树中，所有从根到叶的所有路径，其和为S
 * @author CodeCoderCoding
 */
public class P4BinaryTreeAllPath {
    public static List<List<Integer>> findPaths(TreeNode root, int sum) {
        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<Integer>();
        findPathsRecursive(root, sum, currentPath, allPaths);
        return allPaths;
    }

    private static void findPathsRecursive(TreeNode currentNode, int sum, List<Integer> currentPath,
                                           List<List<Integer>> allPaths) {
        if (currentNode == null)
            return;

        // 添加当前节点到路径中
        currentPath.add(currentNode.val);

        // 如果当前节点是叶子结点并且它的值等于当前总和sum，保存当前路径
        if (currentNode.val == sum && currentNode.left == null && currentNode.right == null) {
            allPaths.add(new ArrayList<Integer>(currentPath));
        } else {
            // 遍历左子树
            findPathsRecursive(currentNode.left, sum - currentNode.val, currentPath, allPaths);
            // 遍历右子树
            findPathsRecursive(currentNode.right, sum - currentNode.val, currentPath, allPaths);
        }

        // 从要回溯的路径中删除当前节点
        // 当我们向上递归调用堆栈时，我们需要删除当前节点。
        currentPath.remove(currentPath.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        int sum = 23;
        List<List<Integer>> result = P4BinaryTreeAllPath.findPaths(root, sum);
        System.out.println("Tree paths with sum " + sum + ": " + result);
    }
}
