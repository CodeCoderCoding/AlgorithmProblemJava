package B4TowPointer.B41Two;

import java.util.*;
/**
 * @author CodeCoderCoding
 */
public class P7TriNumberOfSmallestSum {
    public static int searchTriplets(int[] arr, int target) {
        Arrays.sort(arr);
        int count = 0;
        for (int i = 0; i < arr.length - 2; i++) {//外层循环，遍历数组，取第一个数
            count += searchPair(arr, target - arr[i], i);
        }
        return count;
    }

    //left指针和right指针组成的数对
    private static int searchPair(int[] arr, int targetSum, int first) {
        int count = 0;
        int left = first + 1, right = arr.length - 1;
        while (left < right) {//内存循环，找到符合条件的数对
            if (arr[left] + arr[right] < targetSum) { //找到三元组
                //由于arr[right] >= arr[left],所以我们能将arr[right]替换成
                //left到right之间的任何一个数来得到三数之和小于target sum
                count += right - left;//left这个数 和 left+1到right之间的数组成的right
                left++;
            } else {
                right--; //向左移动right指针，从而得到更小的数对
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(P7TriNumberOfSmallestSum.searchTriplets(new int[] { -1, 0, 2, 3 }, 3));
        System.out.println(P7TriNumberOfSmallestSum.searchTriplets(new int[] { -1, 4, 2, 1, 3 }, 5));
    }
}
