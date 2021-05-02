package leetcode;

/**
 * 只是一个非常简单的一次归并, leetcode却很不合理的将难度标为hard.
 * 此题实际难度为easy
 *
 * @author egbz
 * @date 2021/5/2
 */
public class P4_MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        int n = n1 + n2;
        int[] merged = new int[n];
        int i = 0, j = 0, k = 0;
        double ans;

        while (i < n1 && j < n2) {
            if (nums1[i] <= nums2[j]) {
                merged[k] = nums1[i];
                i++;
                k++;
            } else {
                merged[k] = nums2[j];
                j++;
                k++;
            }
        }
        while (i < n1) {
            merged[k] = nums1[i];
            i++;
            k++;
        }
        while(j < n2) {
            merged[k] = nums2[j];
            j++;
            k++;
        }

        if (n % 2 == 1) {
            ans = merged[n / 2];
        } else {
            if (n == 0) {
                return 0.0;
            }
            ans = (merged[(n-1)/2] + merged[n/2]) / 2.0;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] a = {};
        int[] b = {};
        System.out.println(new P4_MedianOfTwoSortedArrays().findMedianSortedArrays(a, b));
    }
}
