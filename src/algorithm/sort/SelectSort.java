package algorithm.sort;

/**
 * 选择排序
 *
 * @author egbz
 * @date 2021/3/28
 */
public class SelectSort {
    private int[] sort(int[] a) {
        int n = a.length;
        int tem;
        for (int i = 0; i < n-1; i++) {
            int k = i;
            for (int j = i+1; j < n; j++) {
                if (a[k] > a[j])
                    k = j;
            }
            tem = a[k]; a[k] = a[i]; a[i] = tem;
        }
        return a;
    }

    public static void main(String[] args) {
        int[] a = {33, 12, 1, 0, 32, 5, 42, 16, 5, 75, 7, 256, 1024, 543};
        a = new SelectSort().sort(a);
        for (int element : a) {
            System.out.print(element + " ");
        }

    }
}
