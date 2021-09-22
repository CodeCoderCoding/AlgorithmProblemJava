package B4TowPointer.B43SlidingWindow;

import java.util.*;
/**
 * K个不同字符的最长子串的长度
 * @author CodeCoderCoding
 */
public class P3KDiffCharLongestSubString {
    public static int findLength(String str, int k) {
        if (str == null || str.length() == 0 || str.length() < k)
            throw new IllegalArgumentException();

        int windowStart = 0, maxLength = 0;
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        // 接下来的循环我们尝试扩大范围 [windowStart, windowEnd]
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            charFrequencyMap.put(rightChar, charFrequencyMap.getOrDefault(rightChar, 0) + 1);
            // 收缩滑动窗口，直到有k个不同的元素在charFrequencyMap中
            while (charFrequencyMap.size() > k) {
                char leftChar = str.charAt(windowStart);
                charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) - 1);
                if (charFrequencyMap.get(leftChar) == 0) {//当字符出现频率为0时，需要从hashmap中删除该字符
                    charFrequencyMap.remove(leftChar);
                }
                windowStart++; //收缩窗口
            }
            //记住滑动窗口的最大长度
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println("最长子串的长度: " + P3KDiffCharLongestSubString.findLength("araaci", 2));
        System.out.println("最长子串的长度: " + P3KDiffCharLongestSubString.findLength("araaci", 1));
        System.out.println("最长子串的长度: " + P3KDiffCharLongestSubString.findLength("cbbebi", 3));
    }
}
