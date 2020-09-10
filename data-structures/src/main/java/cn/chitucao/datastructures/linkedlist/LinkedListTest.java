package cn.chitucao.datastructures.linkedlist;

/**
 * @author DennyFly
 * @since 2020/2/25 15:54
 */
public class LinkedListTest {
    public static void main(String[] args) {
        ListNode<Integer> linkedList = new ListNode<>();
        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);
        }
        System.out.println(linkedList);

        linkedList.add(2, 666);
        System.out.println(linkedList);

        System.out.println(linkedList.contains(2));

        linkedList.remove(2);
        System.out.println(linkedList);

        linkedList.removeFirst();
        System.out.println(linkedList);

        linkedList.removeLast();
        System.out.println(linkedList);

        linkedList.removeElement(3);
        System.out.println(linkedList);
    }
}
