package B6BFS.B61Tree;
import java.util.*;
/**
 * 二叉树的层序遍历
 * @author CodeCoderCoding
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
};

public class BinaryTreeLevelOrder {
    public static List<List<Integer>> traverse(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<>();//用队列保存每一层的节点，临时存储
        queue.offer(root);//将根节点加入队列
        //外层循环；如果队列不为空，则进行后序操作
        while (!queue.isEmpty()) {
            int levelSize = queue.size();//当前层的元素个数，用于控制每次遍历队列中的元素个数
            List<Integer> currentLevel = new ArrayList<>(levelSize);//保存当前层的节点
            //内层循环；每次遍历队列中的节点
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                //将当前遍历到的元素添加到arrayList中保存
                currentLevel.add(currentNode.val);
                //同时将遍历到的节点的子节点添加到队列中
                if (currentNode.left != null)
                    queue.offer(currentNode.left);
                if (currentNode.right != null)
                    queue.offer(currentNode.right);
            }
            result.add(currentLevel);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        List<List<Integer>> result = BinaryTreeLevelOrder.traverse(root);
        System.out.println("Level order traversal: " + result);
    }
}
