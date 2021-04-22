package algorithm.linearlist;

/**
 * leetcode p142
 * 给出一个链表 返回环开始的节点, 如果没有环则返回null
 *
 * @author egbz
 * @date 2020/12/4
 */
public class DetectCycle {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            this.val = x;
            this.next = null;
        }

        @Override
        public String toString() {
            return "{" + this.val +"}";
        }
    }
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode p1, p2;
        p1 = p2 = head;
        while (p2 != null) {
            if (p1.next != null) {
                p1 = p1.next;
            } else {
                return null;
            }
            if (p2.next != null && p2.next.next != null) {
                p2 = p2.next.next;
            } else {
                return null;
            }
            if (p1 == p2) {
                break;
            }
        }

        p1 = head;
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p1;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        n1.next =n1;
//        ListNode n2 = new ListNode(2);
//        ListNode n3 = new ListNode(3);
//        ListNode n4 = new ListNode(4);
//        ListNode n5 = new ListNode(5);
//        n1.next = n2;
//        n2.next = n3;
//        n3.next = n4;
//        n4.next = n5;
//        n5.next = n2;
        DetectCycle detectCycle = new DetectCycle();
        System.out.println(detectCycle.detectCycle(n1));



    }
}
