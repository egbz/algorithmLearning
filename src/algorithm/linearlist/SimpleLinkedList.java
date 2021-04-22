package algorithm.linearlist;


/**
 * 手写一个单向链表 实现add find
 *
 * @author egbz
 * @date 2020/11/29
 */
public class SimpleLinkedList {
    private class Node<E> {
        E item;
        Node<E> next;
        public Node(E item, Node<E> next) {
            this.item = item;
            this.next = next;
        }
    }

    private Node head;
    private Node tail;

    /**
     * 增加一个节点
     * @param e
     * @param <E>
     */
    private <E> void add(E e) {
        Node node = new Node(e, null);
        if (tail != null) {
            tail.next = node;
            tail = node;
        } else {
            head = tail = node;
        }
    }

    /**
     * 判断e是否在链表里
     * @param e
     * @param <E>
     * @return
     */
    private <E> boolean find(E e) {
        Node p = head;
        while (p != null) {
            if (p.item != null) {
                if (p.item.equals(e)) {
                    return true;
                }
            } else if (e == null) {
                return true;
            }
            p = p.next;
        }
        return false;
    }

    private void printList() {
        Node p = head;
        while (p != null) {
            System.out.print(p.item);
            if (p.next != null) {
                System.out.print(" , ");
            }
            p = p.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SimpleLinkedList list = new SimpleLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(null);
        list.add("four");
        list.printList();

        System.out.println(list.find(null));
        System.out.println(list.find(2));
        System.out.println(list.find(10));

    }


}
