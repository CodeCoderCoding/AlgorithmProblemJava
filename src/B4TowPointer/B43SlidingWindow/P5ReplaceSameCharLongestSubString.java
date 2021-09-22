package B4TowPointer.B43SlidingWindow;

import java.util.*;
/**
 * 替换相同字符后的最长子串
 * @author CodeCoderCoding
 */
public class P5ReplaceSameCharLongestSubString {
    public static int findLength(String str, int k) {
        int windowStart = 0, maxLength = 0, maxRepeatLetterCount = 0;
        Map<Character, Integer> letterFrequencyMap = new HashMap<>();
        // 扩大窗口
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            letterFrequencyMap.put(rightChar, letterFrequencyMap.getOrDefault(rightChar, 0) + 1);
            maxRepeatLetterCount = Math.max(maxRepeatLetterCount, letterFrequencyMap.get(rightChar));

            //
            if (windowEnd - windowStart + 1 - maxRepeatLetterCount > k) {
                char leftChar = str.charAt(windowStart);
                letterFrequencyMap.put(leftChar, letterFrequencyMap.get(leftChar) - 1);
                windowStart++;
            }

            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(P5ReplaceSameCharLongestSubString.findLength("aabccbb", 2));
        System.out.println(P5ReplaceSameCharLongestSubString.findLength("abbcb", 1));
        System.out.println(P5ReplaceSameCharLongestSubString.findLength("abccde", 1));
    }
}
