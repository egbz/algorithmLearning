package leetcode;

import java.util.*;

/**
 * 最长 不重复子串的长度
 * [tips] 队列, 滑动窗口; O(n)
 *
 * p.s. 贪心要考虑策略和反例, 考虑如下几个样例
 *      "dvdf"
 *      "pwwkew"
 *
 *
 * @author egbz
 * @date 2021/4/30
 */
public class P3_LongestSubstringWithoutRepeatingCharacters {


    public int lengthOfLongestSubstring(String s) {
        Queue<Character> queue = new LinkedList<>();
        Set<Character> set = new HashSet<>(256);
        int ans = 0, num = 0;

        for (char c : s.toCharArray()) {
            if (!set.contains(c)) {
                set.add(c);
                queue.offer(c);
                num += 1;
            } else {
                ans = Math.max(ans, num);
                do {
                    char out = queue.poll();
                    set.remove(out);
                    num -= 1;
                } while (set.contains(c));
                queue.offer(c);
                set.add(c);
                num += 1;
            }
        }
        return Math.max(ans, num);
    }


    public static void main(String[] args) {
        String s1 = "pwwkew";
        System.out.println(new P3_LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(s1));
    }
}
