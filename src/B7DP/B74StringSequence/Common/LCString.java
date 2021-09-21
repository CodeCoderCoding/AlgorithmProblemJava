package B7DP.B74StringSequence.Common;

/**
 * @author supremepole
 * 最长公共子串
 */
public class LCString {
    public int findLCSLength(String s1, String s2) {
        return findLCSLengthRecursive(s1, s2, 0, 0, 0);
    }

    private int findLCSLengthRecursive(String s1, String s2, int i1, int i2, int count) {
        if(i1 == s1.length() || i2 == s2.length())
            return count;

        if(s1.charAt(i1) == s2.charAt(i2)) {
            count = findLCSLengthRecursive(s1, s2, i1 + 1, i2 + 1, count + 1);
        }
        int c1 = findLCSLengthRecursive(s1, s2, i1, i2+1, 0);
        int c2 = findLCSLengthRecursive(s1, s2, i1+1, i2, 0);

        return Math.max(count, Math.max(c1, c2));
    }

    public static void main(String[] args) {
        LCString lcString = new LCString();
        System.out.println(lcString.findLCSLength("cbda", "cbda"));//4
        System.out.println(lcString.findLCSLength("abdca", "cbda"));//2
        System.out.println(lcString.findLCSLength("passport", "ppsspt"));//3
    }
}