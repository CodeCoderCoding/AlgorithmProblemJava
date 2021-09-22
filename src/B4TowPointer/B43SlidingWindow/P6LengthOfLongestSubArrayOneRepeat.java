package B4TowPointer.B43SlidingWindow;

/**
 * 一次替换后的最长子数组的长度
 * @author CodeCoderCoding
 */
public class P6LengthOfLongestSubArrayOneRepeat {
    public static int findLength(int[] arr, int k) {
        int windowStart = 0, maxLength = 0, maxOnesCount = 0;
        // 扩大窗口
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            if (arr[windowEnd] == 1)
                maxOnesCount++;

            //
            if (windowEnd - windowStart + 1 - maxOnesCount > k) {
                if (arr[windowStart] == 1)
                    maxOnesCount--;
                windowStart++;
            }

            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(P6LengthOfLongestSubArrayOneRepeat.findLength(new int[] { 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1 }, 2));
        System.out.println(P6LengthOfLongestSubArrayOneRepeat.findLength(new int[] { 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1 }, 3));
    }
}
