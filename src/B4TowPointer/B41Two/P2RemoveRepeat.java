package B4TowPointer.B41Two;

/**
 * 移除重复元素
 * @author CodeCoderCoding
 */
public class P2RemoveRepeat {
    public static int remove(int[] arr) {
        int nextNonDuplicate = 1; //下一个非重复元素的索引
        for (int i = 1; i < arr.length; i++) {
            if (arr[nextNonDuplicate - 1] != arr[i]) {
                arr[nextNonDuplicate] = arr[i];
                nextNonDuplicate++;
            }
        }

        return nextNonDuplicate;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 2, 3, 3, 3, 6, 9, 9 };
        System.out.println(P2RemoveRepeat.remove(arr));

        arr = new int[] { 2, 2, 2, 11 };
        System.out.println(P2RemoveRepeat.remove(arr));
    }
}
