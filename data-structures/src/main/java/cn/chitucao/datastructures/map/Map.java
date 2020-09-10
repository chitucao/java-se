package cn.chitucao.datastructures.map;

/**
 * @author DennyFly
 * @since 2020/7/2 10:43
 */
public interface Map<K, V> {

    int getSize();

    boolean isEmpty();

    void add(K key, V value);

    V get(K key);

    boolean contains(K key);

    void set(K key, V newValue);

    V remove(K key);
}
