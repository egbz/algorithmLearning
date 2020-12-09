package sort;

/**
 * 冒泡排序
 * @author egbz
 * @date 2020/12/9
 */
public class BubbleSort {

    private int[] sort(int[] a) {
        int n = a.length;
        int tem;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (a[i] > a[j]) {
                    tem = a[i]; a[i] = a[j]; a[j] = tem;
                }
            }
        }
        return a;
    }

    private void test() {
        int[] before = {4, 2, 10, 53, 0, 234, 8};
        int[] after = sort(before);
        for (int element : after) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        new BubbleSort().test();
    }
}
