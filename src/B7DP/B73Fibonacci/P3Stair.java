package B7DP.B73Fibonacci;

/**
 * 跳楼梯：对于有n步的楼梯，每一步可走1，2或3步，多少种可能的方式走到楼顶
 * @author CodeCoderCoding
 */
public class P3Stair {
    public int CountWays(int n) {
        if( n == 0)
            return 1; // 基础情况，我们不需要去减任何步数，因此只有一种解法

        if(n == 1)
            return 1; // 我们可以减去1然后剩下0，因此只有一种解法

        if(n == 2)
            return 2; // 我们可以减去1两次，因此只有一种解法

        // 如果我们走1步，那么剩下的台阶我们要走n-1步;
        int take1Step = CountWays(n-1);
        // 如果我们走2步，那么剩下的台阶我们要走n-2步;
        int take2Step = CountWays(n-2);
        // 如果我们走3步，那么剩下的台阶我们要走n-3步;
        int take3Step = CountWays(n-3);

        return take1Step + take2Step + take3Step;
    }

    public static void main(String[] args) {
        P3Stair sc = new P3Stair();
        System.out.println(sc.CountWays(3));
        System.out.println(sc.CountWays(4));
        System.out.println(sc.CountWays(5));
    }
}
