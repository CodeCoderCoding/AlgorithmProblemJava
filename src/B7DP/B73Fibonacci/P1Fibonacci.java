package B7DP.B73Fibonacci;

/**
 * 求斐波那契数
 * @author CodeCoderCoding
 */
public class P1Fibonacci {
    public int CalculateFibonacci(int n) {
        if(n < 2)
            return n;
        return CalculateFibonacci(n-1) + CalculateFibonacci(n-2);
    }

    public static void main(String[] args) {
        P1Fibonacci fib = new P1Fibonacci();
        System.out.println("第5个斐波那契数为：" + fib.CalculateFibonacci(5));
        System.out.println("第6个斐波那契数为：" + fib.CalculateFibonacci(6));
        System.out.println("第7个斐波那契数为：" + fib.CalculateFibonacci(7));
    }
}
