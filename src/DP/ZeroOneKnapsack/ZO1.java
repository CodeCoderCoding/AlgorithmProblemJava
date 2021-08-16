package DP.ZeroOneKnapsack;

/**
 * @author supremepole
 * 01背包，最大盈利：已知N个物品的重量和利润，我们将这些物品放入容量为C的背包。目标是背包中的物品中获得最大的利润。每个物品只能选择一次。
 */
public class ZO1 {
    public int solveKnapsack(int[] profits, int[] weights, int capacity) {
        return this.knapsackRecursive(profits, weights, capacity, 0);
    }
    //currentIndex是用于确定当前遍历到的元素的索引
    private int knapsackRecursive(int[] profits, int[] weights, int capacity, int currentIndex) {
        //基准检查
        if (capacity <= 0 || currentIndex >= profits.length)
            return 0;

        //选择当前物品后递归调用
        //如果当前物品的重量超过容量，则不继续递归调用
        int profit1 = 0;
        if( weights[currentIndex] <= capacity )
            profit1 = profits[currentIndex] + knapsackRecursive(profits, weights,
                    capacity - weights[currentIndex], currentIndex + 1);

        //排除当前索引的物品后递归调用
        int profit2 = knapsackRecursive(profits, weights, capacity, currentIndex + 1);

        return Math.max(profit1, profit2);
    }

    public static void main(String[] args) {
        ZO1 zo1 = new ZO1();
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int maxProfit = zo1.solveKnapsack(profits, weights, 7);
        System.out.println("总的背包盈利 ---> " + maxProfit);
        maxProfit = zo1.solveKnapsack(profits, weights, 6);
        System.out.println("总的背包盈利 ---> " + maxProfit);
    }
}
