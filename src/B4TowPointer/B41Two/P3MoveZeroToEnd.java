package B4TowPointer.B41Two;

/**
 * 移动零到末尾
 * @author CodeCoderCoding
 */
public class P3MoveZeroToEnd {
    public void moveZeroes(int[] nums) {
        int n = nums.length, left = 0, right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                nums[left]=nums[right];
                left++;
            }
            right++;
        }
        //非0元素统计完了，剩下的都是0了
        //所以第二次遍历把末尾的元素都赋0即可
        for(int i=left;i<nums.length;i++){
            nums[i]=0;
        }
    }
}
