package sort;

/**
 * 快排 O(nlogn)
 * 最常用, 不稳定
 *
 * @author egbz
 * @date 2021/3/28
 */
public class Qsort {
    private void qsort(int[] d, int head, int tail) {
        int x = d[head], i = head, j = tail;
        while (i < j) {
            while (i < j && d[j] >= x) j--;
            d[i] = d[j];
            while (i < j && d[i] <= x) i++;
            d[j] = d[i];
        }
        d[i] = x;
        if (head < i-1)
            qsort(d, head, i-1);
        if (i+1 < tail)
            qsort(d, i+1, tail);
    }

    public static void main(String[] args) {
        int[] a = {33, 12, 1, 0, 32, 5, 42, 16, 5, 75, 7, 256, 1024, 543};
        int n = a.length;
        new Qsort().qsort(a, 0, n-1);
        for (int ele : a) {
            System.out.print(ele + " ");
        }
    }
}
