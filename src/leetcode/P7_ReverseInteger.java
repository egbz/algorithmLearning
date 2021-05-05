package leetcode;

/**
 * 自己写的稀碎, 各种特判, 优雅尽失
 * 还是StringBuilder好用
 * @author egbz
 * @date 2021/5/5
 */
public class P7_ReverseInteger {

    public int reverse(int x) {
        if (x == Integer.MIN_VALUE) {
            return 0;
        }

        int[] a = new int[10];
        int weight = 10, index = 0;
        boolean positive = x > 0;
        int ans = 0;

        x = Math.abs(x);
        while (x > 0) {
            if (index == 8) {
                a[index] = (x / 100000000) % 10;
                x -= a[index] * 100000000;
                index++;
                weight *= 10;
                continue;

            } else if (index == 9) {
                a[index] = x / 1000000000;
                weight *= 10;
                index++;
                break;
            }

            a[index] = (x % weight) / (weight / 10);
            x -= x % weight;
            index++;
            weight *= 10;
        }

        index--;
        for (int i = 0; i <= index; i++) {
            if (index == 9 && i == 0 && a[i] > 2) {
                return 0;
            }
            ans += a[i] * ((Double)Math.pow(10, index - i)).intValue();
            if (ans < 0) {
                return 0;
            }
        }
        ans = positive ? ans : -ans;
        return ans;
    }

    public int elegantReverse(int x) {
        String reverse = new StringBuilder().append(Math.abs(x)).reverse().toString();
        try {
            return x >= 0 ? Integer.parseInt(reverse) : Integer.parseInt(reverse) * -1;
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(new P7_ReverseInteger().elegantReverse(120));
    }


}
