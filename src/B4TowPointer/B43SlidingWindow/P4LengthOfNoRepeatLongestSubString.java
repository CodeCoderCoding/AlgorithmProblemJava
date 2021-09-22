package B4TowPointer.B43SlidingWindow;

import java.util.*;
/**
 * 非重复最长子串的长度
 * @author CodeCoderCoding
 */
public class P4LengthOfNoRepeatLongestSubString {
    public static int findLength(String str) {
        int windowStart = 0, maxLength = 0;
        Map<Character, Integer> charIndexMap = new HashMap<>();
        // 扩大窗口
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            //如果map中已经含有字符rightChar，从滑动窗口的开头端收缩窗口，这样才能使得rightChar出现一次
            if (charIndexMap.containsKey(rightChar)) {
                // 将windowStart变为rightChar第一次出现的位置
                windowStart = Math.max(windowStart, charIndexMap.get(rightChar) + 1);
            }
            charIndexMap.put(rightChar, windowEnd); // 将rightChar添加到map中
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1); // 记住当前的非重复字符串的最大长度
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println("最长子串的长度: " + P4LengthOfNoRepeatLongestSubString.findLength("aabccbb"));
        System.out.println("最长子串的长度: " + P4LengthOfNoRepeatLongestSubString.findLength("abbbb"));
        System.out.println("最长子串的长度: " + P4LengthOfNoRepeatLongestSubString.findLength("abccde"));
    }
}
