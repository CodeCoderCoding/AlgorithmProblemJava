package B7DP.B73Fibonacci;

/**
 * 数因问题：计算有多少种可能的方式将n表示为1,3或4的总和
 * @author CodeCoderCoding
 */
public class P2NumberFactor {
    public int CountWays(int n) {
        if (n == 0)
            return 1; // 基础情况，我们不需要去减任何步数，因此只有一种解法

        if (n == 1)
            return 1; // 我们可以减去1然后剩下0，因此只有一种解法

        if (n == 2)
            return 1; // 我们可以减去1两次，因此只有一种解法

        if (n == 3)
            return 2; // '3' 能被表达成 {1,1,1}, {3}

        // 如果我们减去1，我们将剩下 'n-1'
        int subtract1 = CountWays(n - 1);
        // 如果我们减去3，我们将剩下 'n-3'
        int subtract3 = CountWays(n - 3);
        // 如果我们减去4，我们将剩下 'n-1'
        int subtract4 = CountWays(n - 4);

        return subtract1 + subtract3 + subtract4;
    }

    public static void main(String[] args) {
        P2NumberFactor en = new P2NumberFactor();
        System.out.println(en.CountWays(4));
        System.out.println(en.CountWays(5));
        System.out.println(en.CountWays(6));
    }
}
