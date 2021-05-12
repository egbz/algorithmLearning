package leetcode;

/**
 * @author egbz
 * @date 2021/5/12
 */
public class P9_Palindrome_Number {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int num = x;
        int a = 0;
        while (num != 0) {
            a = a * 10 + num % 10;
            num /= 10;
        }
//        System.out.println(a);
        return a == x;
    }

    public static void main(String[] args) {
        System.out.println(new P9_Palindrome_Number().isPalindrome(Integer.MAX_VALUE));
    }
}
