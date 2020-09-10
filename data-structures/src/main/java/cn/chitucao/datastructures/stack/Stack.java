package cn.chitucao.datastructures.stack;

/**
 * @author DennyFly
 * @since 2020/2/25 16:11
 */
public interface Stack<E> {
    int getSize();

    boolean isEmpty();

    void push(E e);

    E pop();

    E peek();
}
