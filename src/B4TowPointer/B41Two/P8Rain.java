package B4TowPointer.B41Two;

/**
 * 接雨水问题
 * @author CodeCoderCoding
 */
public class P8Rain {
    public static void main(String[] args) {
        int[] arr=new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(Rain1(arr));
    }
    public static int Rain1(int[] height) {
        if (height == null || height.length == 0) return 0;
        int n = height.length;
        int res = 0;
        // 跳过最左边和最右边的柱子，从第二个柱子开始
        for (int i = 1; i < n - 1; i++) {
            int maxLeft = 0, maxRight = 0;
            // 找右边最高的柱子
            for (int j = i; j < n; j++) {
                maxRight = Math.max(maxRight, height[j]);
            }
            // 找左边最高的柱子
            for (int j = i; j >= 0; j--) {
                maxLeft = Math.max(maxLeft, height[j]);
            }
            // 如果自己就是最高的话，那么maxLeft == maxRight == height[i]，此时所能装水为0
            res += Math.min(maxLeft, maxRight) - height[i];
        }
        return res;
    }
}
