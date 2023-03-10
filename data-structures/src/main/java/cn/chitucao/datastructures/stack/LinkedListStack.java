package cn.chitucao.datastructures.stack;

import cn.chitucao.datastructures.linkedlist.ListNode;

/**
 * @author DennyFly
 * @since 2020/2/25 16:13
 */
public class LinkedListStack<E> implements Stack<E> {

    private ListNode<E> linkedList;

    public LinkedListStack() {
        this.linkedList = new ListNode<>();
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public void push(E e) {
        linkedList.addFirst(e);
    }

    @Override
    public E pop() {
        return linkedList.removeFirst();
    }

    @Override
    public E peek() {
        return linkedList.getFirst();
    }


    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack: top ");
        res.append(linkedList);
        return res.toString();
    }

    public static void main(String[] args) {
        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        for (int i = 0; i < 5; i++) {
            linkedListStack.push(i);
        }
        System.out.println(linkedListStack);

        linkedListStack.pop();
        System.out.println(linkedListStack);

        System.out.println(linkedListStack.peek());
    }
}
