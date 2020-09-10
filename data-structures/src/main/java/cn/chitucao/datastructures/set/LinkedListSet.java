package cn.chitucao.datastructures.set;

import cn.chitucao.datastructures.linkedlist.ListNode;

/**
 * @author DennyFly
 * @since 2020/7/2 10:17
 */
public class LinkedListSet<E> implements Set<E> {

    private ListNode<E> linkedList;

    public LinkedListSet() {
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
    public void add(E e) {
        if (contains(e)) {
            return;
        }
        linkedList.addFirst(e);
    }

    @Override
    public boolean contains(E e) {
        return linkedList.contains(e);
    }

    @Override
    public void remove(E e) {
        linkedList.removeElement(e);
    }
}
