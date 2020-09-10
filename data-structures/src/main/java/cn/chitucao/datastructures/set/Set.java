package cn.chitucao.datastructures.set;

/**
 * @description:
 * @author: dennyfly.zhu
 * @since: 2020-06-30 22:38
 **/
public interface Set<E> {
    void add(E e);
    boolean contains(E e);
    void remove(E e);
    int getSize();
    boolean isEmpty();
}
