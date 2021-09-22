package B4TowPointer.B43SlidingWindow;

/**
 * 给定和的最小子数组
 * @author CodeCoderCoding
 */
public class P2MinSubArray {
    public static int findMinSubArray(int S, int[] arr) {
        int windowSum = 0, minLength = Integer.MAX_VALUE;
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd]; //添加后一个元素
            //收缩窗口，直到windowSum<S
            while (windowSum >= S) {
                minLength = Math.min(minLength, windowEnd - windowStart + 1);
                windowSum -= arr[windowStart]; //减去从滑动窗口移除的元素
                windowStart++; //向前滑动窗口
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public static void main(String[] args) {
        int result = P2MinSubArray.findMinSubArray(7, new int[] { 2, 1, 5, 2, 3, 2 });
        System.out.println("最小子数组的长度: " + result);
        result = P2MinSubArray.findMinSubArray(7, new int[] { 2, 1, 5, 2, 8 });
        System.out.println("最小子数组的长度: " + result);
        result = P2MinSubArray.findMinSubArray(8, new int[] { 3, 4, 1, 1, 6 });
        System.out.println("最小子数组的长度: " + result);
    }
}
