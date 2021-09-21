package B7DP.B74StringSequence.Plalindrome;

/**
 * 最长回文子序列问题
 * @author CodeCoderCoding
 */
public class P1LPSubSequence {
    public int findLPSLength(String st) {
        return findLPSLengthRecursive(st, 0, st.length()-1);
    }

    private int findLPSLengthRecursive(String st, int startIndex, int endIndex) {
        if(startIndex > endIndex)
            return 0;

        //有一个元素的序列是一个长度为1的回文序列
        if(startIndex == endIndex)
            return 1;

        //选项1：序列头和尾的元素相同
        if(st.charAt(startIndex) == st.charAt(endIndex))
            return 2 + findLPSLengthRecursive(st, startIndex+1, endIndex-1);

        //选项2： 从开头或结尾跳过一个元素
        int c1 =  findLPSLengthRecursive(st, startIndex+1, endIndex);
        int c2 =  findLPSLengthRecursive(st, startIndex, endIndex-1);
        return Math.max(c1, c2);
    }

    public static void main(String[] args) {
        P1LPSubSequence lps = new P1LPSubSequence();
        System.out.println(lps.findLPSLength("abdbca"));
        System.out.println(lps.findLPSLength("cddpd"));
        System.out.println(lps.findLPSLength("pqr"));
    }
}
