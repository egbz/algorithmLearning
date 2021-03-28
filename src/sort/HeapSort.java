package sort;

/**
 * 堆排序 O(nlogn)
 * 不稳定
 *
 * @author egbz
 * @date 2021/3/28
 */
public class HeapSort {
    private void down(int[] d, int tot, int i) {
        int j, tem;
        while (i <= tot/2 - 1) {
            j = 2 * i + 1;
            if (j + 1 < tot && d[j+1] < d[j]) {
                j++;
            }
            if (d[i] > d[j]) {
                tem = d[i]; d[i] = d[j]; d[j] = tem;
                i = j;
            } else {
                break;
            }
        }
    }
    private void sort(int[] d) {
        int tot = d.length;
        int n = tot;
        int tem;

        for (int i = tot/2 - 1; i >= 0; i--) {
            down(d, tot, i);
        }
        for (int i = 0; i < n; i++) {
            tem = d[0]; d[0] = d[tot-1]; d[tot-1] = tem;
            tot--;
            down(d, tot,0);
        }

//        reverse
        for (int i = 0; i <= n/2 - 1; i++) {
            tem = d[i]; d[i] = d[n-i-1]; d[n-i-1] = tem;
        }
    }

    public static void main(String[] args) {
        int[] d = {33, 12, 1, 0, 32, 5, 42, 16, 5, 75, 7, 256, 1024, 543};
        new HeapSort().sort(d);
        for (int ele : d) {
            System.out.print(ele + " ");
        }
    }
}
