package algorithm.sort;

/**
 * 归并排序 O(nlogn)
 * 稳定
 *
 * @author egbz
 * @date 2021/3/28
 */
public class MergeSort {
    private void msort(int[] a, int[] b, int l, int  r) {
        if (l == r) return;
        int m =(l + r) / 2;
        msort(a, b, l, m);
        msort(a, b, m+1, r);
        int i = l, j = m + 1, k = l;
        while (i <= m && j <= r) {
            if (a[i] <= a[j]) {
                b[k] = a[i]; i++; k++;
            } else {
                b[k] = a[j]; j++; k++;
            }
        }
        while (i <= m) {
            b[k] = a[i]; i++; k++;
        }
        while(j <= r) {
            b[k] = a[j]; j++; k++;
        }
        for (i = l; i <= r; i++) {
            a[i] = b[i];
        }
    }

    public static void main(String[] args) {
        int[] a = {33, 12, 1, 0, 32, 5, 42, 16, 5, 75, 7, 256, 1024, 543};
        int[] b = new int[14];
        new MergeSort().msort(a, b, 0, a.length - 1);
        for (int ele : a) {
            System.out.print(ele + " ");
        }

    }
}
