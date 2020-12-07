package linear;

/**
 * 将单向链表反转
 * @author egbz
 * @date 2020/12/7
 */
public class ReverseList {
    private class Node {
        int val;
        Node next;
        public Node(int val) {
            this.val = val;
        }
    }

    private Node resolve(Node head) {
        Node next, pre = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    private void print(Node head) {
        while (head != null) {
            System.out.print(head.val + ", ");
            head = head.next;
        }
        System.out.println();
    }

    private void test() {
        Node n1 = new Node(1);
        Node n2 = new Node (2);
        Node n3 = new Node (3);
        Node n4 = new Node(4);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = null;

        Node head = n1;

        print(head);
        print(resolve(head));

    }

    public static void main(String[] args) {
        new ReverseList().test();

    }
}
