package leetcode;

/**
 * [tips] 高精度加法 + 链表操作
 * @author egbz
 * @date 2021/4/29
 */
public class P2_AddTwoNumbers {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode p1 = head, p2;
        int plus = 0;

        while (l1 != null && l2 != null) {
            int num = plus + l1.val + l2.val;
            p2 = new ListNode(num % 10);
            p1.next = p2;
            p1 = p2;
            plus = num / 10;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int num = plus + l1.val;
            p2 = new ListNode(num % 10);
            p1.next = p2;
            p1 = p2;
            plus = num / 10;
            l1 = l1.next;
        }

        while (l2 != null) {
            int num = plus + l2.val;
            p2 = new ListNode(num % 10);
            p1.next = p2;
            p1 = p2;
            plus = num / 10;
            l2 = l2.next;
        }

        if (l1 == null && l2 == null && plus != 0) {
            p1.next = new ListNode(plus);
            plus = 0;
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(1);
        ListNode a3 = new ListNode(9);
        a1.next = a2; a2.next = a3;

        ListNode b1 = new ListNode(1);
        ListNode b2 = new ListNode(1);
        ListNode b3 = new ListNode(1);
        ListNode b4 = new ListNode(9);

        b1.next = b2; b2.next = b3; b3.next = b4;

        ListNode c1 = new ListNode(0);

        ListNode d1 = new ListNode(0);

//        ListNode l = new P2_AddTwoNumbers().addTwoNumbers(a1, b1);
        ListNode l = new P2_AddTwoNumbers().addTwoNumbers(c1, d1);

        System.out.println("ee");


    }

}
