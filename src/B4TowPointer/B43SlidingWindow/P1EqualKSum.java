package B4TowPointer.B43SlidingWindow;

/**
 * 连续K个元素的子数组的最大和
 * @author CodeCoderCoding
 */
public class P1EqualKSum {
    public static int findMaxSumSubArray(int k, int[] arr) {
        int maxSum = 0, windowSum;
        for (int i = 0; i <= arr.length - k; i++) {
            windowSum = 0;
            for (int j = i; j < i + k; j++) {
                windowSum += arr[j];
            }
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println("大小为K的子数组的最大和："
                + P1EqualKSum.findMaxSumSubArray(3, new int[] { 2, 1, 5, 1, 3, 2 }));
        System.out.println("大小为K的子数组的最大和："
                + P1EqualKSum.findMaxSumSubArray(2, new int[] { 2, 3, 4, 1, 5 }));
    }
}
