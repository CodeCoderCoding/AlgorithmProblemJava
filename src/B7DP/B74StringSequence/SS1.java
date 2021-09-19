package B7DP.B74StringSequence;

/**
 * @author supremepole
 * 最长公共子串
 */
public class SS1 {
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
        SS1 ss1 = new SS1();
        System.out.println(ss1.findLCSLength("cbda", "cbda"));//4
        System.out.println(ss1.findLCSLength("abdca", "cbda"));//2
        System.out.println(ss1.findLCSLength("passport", "ppsspt"));//3
    }
}
