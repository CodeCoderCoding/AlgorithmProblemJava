package B7DP.B72UnboundedKnapsack;

/**
 * @author supremepole
 * 无限背包，最大盈利：已知N个物品的重量和利润，我们被要求把这些物品放在一个容量为C的背包里。
 * 目标是从背包中的物品中获得最大的利润。
 * 0/1背包问题和这个问题的唯一区别是，我们可以使用无限数量的物品。
 */
public class UK1 {
    public int solveKnapsack(int[] profits, int[] weights, int capacity) {
        return this.knapsackRecursive(profits, weights, capacity, 0);
    }

    private int knapsackRecursive(int[] profits, int[] weights, int capacity, int currentIndex) {
        //基准检查
        if (capacity <= 0 || profits.length == 0 || weights.length != profits.length ||
                currentIndex >= profits.length)
            return 0;

        //选择当前物品后递归调用
        //如果当前物品的重量超过容量，则不继续递归调用
        int profit1 = 0;
        if (weights[currentIndex] <= capacity)
            profit1 = profits[currentIndex]
                    + knapsackRecursive(profits, weights, capacity - weights[currentIndex], currentIndex);

        //排除当前索引的物品后递归调用
        int profit2 = knapsackRecursive(profits, weights, capacity, currentIndex + 1);

        return Math.max(profit1, profit2);
    }

    public static void main(String[] args) {
        UK1 uk1 = new UK1();
        int[] profits = { 15, 50, 60, 90 };
        int[] weights = { 1, 3, 4, 5 };
        int maxProfit = uk1.solveKnapsack(profits, weights, 8);
        System.out.println(maxProfit);
    }
}
