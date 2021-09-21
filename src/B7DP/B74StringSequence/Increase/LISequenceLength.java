package B7DP.B74StringSequence.Increase;

/**
 * 求最长递增子序列的长度
 *
 * @author CodeCoderCoding
 */
public class LISequenceLength {
    public static void main(String[] args) {
        int[] nums = {4,2,3,6,10,1,12};
        System.out.println(LISequenceLenthRecursive(nums,0));//5
        System.out.println(LISequenceLengthIterate(nums));//5
    }
    public static int LISequenceLenthRecursive(int[] arr, int currentIndex){
        if(currentIndex==arr.length){//这里不是arr.length-1的原因是，arr.length-1处的字符也要参加运算。arr.length类似于树的遍历，出了边界边界然后回退一步
            return 0;
        }
        int length1=0;
        if(currentIndex==0 || arr[currentIndex]>arr[currentIndex-1]){
            length1=1+ LISequenceLenthRecursive(arr,currentIndex+1);
        }

        int length2= LISequenceLenthRecursive(arr,currentIndex+1);

        return Math.max(length1,length2);
    }
    public static int LISequenceLenthRecursive2(int[] arr, int currentIndex){
        if(currentIndex==arr.length){//这里不是arr.length-1的原因是，arr.length-1处的字符也要参加运算。arr.length类似于树的遍历，出了边界边界然后回退一步
            return 0;
        }
        int length1=0;
        if(currentIndex==0 || arr[currentIndex]>arr[currentIndex-1]){
            length1=1+ LISequenceLenthRecursive(arr,currentIndex+1);
        }

        int length2= LISequenceLenthRecursive(arr,currentIndex+1);

        return Math.max(length1,length2);
    }
    public static int LISequenceLengthIterate(int[] arr){
        int[] dp=new int[arr.length];//dp[i]表示在以arr[i]这个数结尾的情况下，arr[0...i]中的最大递增子序列长度
        int maxLength=0;
        for(int i=0;i<arr.length;i++){
            dp[i]=1;
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            maxLength=Math.max(maxLength,dp[i]);
        }
        return maxLength;
    }
    public static int LISequenceLengthIterate2(int[] arr){
        int[] dp=new int[arr.length];//dp[i]表示在以arr[i]这个数结尾的情况下，arr[0...i]中的最大递增子序列长度
        int maxLength=0;
        for(int i=0;i<arr.length;i++){
            dp[i]=1;
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            maxLength=Math.max(maxLength,dp[i]);
        }
        return maxLength;
    }
}
