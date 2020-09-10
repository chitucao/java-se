package cn.chitucao.datastructures.unionfind;

/**
 * @author DennyFly
 * @since 2020/6/17 14:47
 */
public interface UF {
    int getSize();

    boolean isConnected(int p, int q);

    void unionElements(int p, int q);
}
