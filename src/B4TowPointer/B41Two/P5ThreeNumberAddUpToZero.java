package B4TowPointer.B41Two;
import java.util.*;
/**
 * 和为0的三个数
 * @author CodeCoderCoding
 */
public class P5ThreeNumberAddUpToZero {
    public static List<List<Integer>> searchTriplets(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> triplets = new ArrayList<>();
        for (int i = 0; i < arr.length - 2; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) //跳过相同的元素去避免重复的三元组
                continue;
            searchPair(arr, -arr[i], i + 1, triplets);
        }

        return triplets;
    }

    private static void searchPair(int[] arr, int targetSum, int left, List<List<Integer>> triplets) {
        int right = arr.length - 1;
        while (left < right) {
            int currentSum = arr[left] + arr[right];
            if (currentSum == targetSum) { //找到三元组
                triplets.add(Arrays.asList(-targetSum, arr[left], arr[right]));
                left++;
                right--;
                //此处需要left<right是因为下面需要left++，而left++之前一定要检查left是否小于right
                while (left < right && arr[left] == arr[left - 1])
                    left++; //跳过相同的元素避免相同的三元组
                while (left < right && arr[right] == arr[right + 1])
                    right--; //跳过相同的元素避免相同的三元组
            } else if (targetSum > currentSum)
                left++; //我们将left指针右移来得到一个更大的数，从而得到更大的currentSum
            else
                right--; //我们将right指针左移来得到一个更小的数，从而得到更小的currentSum
        }
    }

    public static void main(String[] args) {
        System.out.println(P5ThreeNumberAddUpToZero.searchTriplets(new int[] { -3, 0, 1, 2, -1, 1, -2 }));
        System.out.println(P5ThreeNumberAddUpToZero.searchTriplets(new int[] { -5, 2, -1, -2, 3 }));
    }
}
