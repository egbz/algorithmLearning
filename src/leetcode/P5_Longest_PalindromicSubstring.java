package leetcode;

/**
 * @author egbz
 * @date 2021/5/3
 */
public class P5_Longest_PalindromicSubstring {
    public String longestPalindrome(String s) {
        int n = s.length();
        int count = 0;
        String palindrome = "";

        for (int i = 0; i < n; i++) {
            int tem = 1;
            if (count == 0) {
                count = 1;
                palindrome = s.substring(i, i + 1);
            }
            int l = i - 1 , r = i + 1;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                tem += 2;
                l--;
                r++;
            }
            if (tem > count) {
                count = tem;
                palindrome = s.substring(l + 1, r);
            }

            if (i > 0 && s.charAt(i) == s.charAt(i - 1)) {
                l = i - 1;
                r = i;
                tem = 0;
                while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                    tem += 2;
                    l--;
                    r++;
                }
                if (tem > count) {
                    count = tem;
                    palindrome = s.substring(l + 1, r);
                }
            }

        }
        return palindrome;
    }

    public static void main(String[] args) {
        System.out.println(new P5_Longest_PalindromicSubstring().longestPalindrome(""));
    }

}
