package B7DP.B74StringSequence.Common;

/**
 * @author CodeCoderCoding
 * 最长公共子序列
 */
public class LCSequence {
    public int findLCSLength(String s1, String s2) {
        return findLCSLengthRecursive(s1, s2, 0, 0);
    }

    private int findLCSLengthRecursive(String s1, String s2, int i1, int i2) {
        if(i1 == s1.length() || i2 == s2.length())
            return 0;

        if(s1.charAt(i1) == s2.charAt(i2)){
            return 1+findLCSLengthRecursive(s1, s2, i1+1, i2+1);//最长公共子串这里不能直接返回
        }
        int c1 = findLCSLengthRecursive(s1, s2, i1, i2+1);
        int c2 = findLCSLengthRecursive(s1, s2, i1+1, i2);

        return Math.max(c1, c2);
    }

    public static void main(String[] args) {
        LCSequence ss2 = new LCSequence();

        System.out.println(ss2.findLCSLength("abdca", "cbda"));//3
        System.out.println(ss2.findLCSLength("passport", "ppsspt"));//5
    }
}
