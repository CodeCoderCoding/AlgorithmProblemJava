package B7DP.B73Fibonacci;

/**
 * @author CodeCoderCoding
 * 母牛数量问题
 */
public class P6CowAmount {
    public static void main(String[] args) {
        System.out.println(cowNums(6));//9
    }
    public static int cowNums(int n){
        int[] dp=new int[n+1];
        if(n<=3){
            return n;
        }
        dp[0]=0;
        dp[1]=1;
        dp[2]=2;
        dp[3]=3;
        for(int i=4;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-3];
        }
        return dp[n];
    }
}
