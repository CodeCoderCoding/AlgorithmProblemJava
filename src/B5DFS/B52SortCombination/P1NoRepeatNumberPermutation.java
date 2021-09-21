package B5DFS.B52SortCombination;

import java.util.*;
/**
 * 无重复数字的全排列
 * @author CodeCoderCoding
 */
public class P1NoRepeatNumberPermutation {
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        // 使用一个动态数组保存所有可能的全排列
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        boolean[] used = new boolean[len];
        //deque为双端队列，用来实现一个栈
        //path为路径
        Deque<Integer> path = new ArrayDeque<>(len);
        dfs(nums, len, 0, path, used, res);
        return res;
    }

    private void dfs(int[] nums, int len, int depth, Deque<Integer> path, boolean[] used, List<List<Integer>> res) {
        if (depth == len) {
            //变量 path 所指向的列表 在深度优先遍历的过程中只有一份 ，
            //深度优先遍历完成以后，回到了根结点，成为空列表。
            //在 Java 中，参数传递是 值传递，对象类型变量在传参的过程中，复制的是变量的地址
            //这些地址被添加到 res 变量，但实际上指向的是同一块内存地址
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (used[i]) {
                break;
            }
            path.addLast(nums[i]);
            used[i] = true;
            dfs(nums, len, depth + 1, path, used, res);
            used[i] = false;
            path.removeLast();
        }
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        P1NoRepeatNumberPermutation solution = new P1NoRepeatNumberPermutation();
        List<List<Integer>> lists = solution.permute(nums);
    }
}
