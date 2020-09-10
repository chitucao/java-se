package cn.chitucao.datastructures.unionfind;

/**
 * @author DennyFly
 * @since 2020/6/17 14:50
 */
public class UnionFind1 implements UF {

    private int[] id;

    public UnionFind1(int size) {
        id = new int[size];
        for (int i = 0; i < size; i++) {
            id[i] = i;
        }
    }

    private int find(int p) {
        if (p < 0 || p >= id.length) {
            throw new IllegalArgumentException("p is out of bound.");
        }
        return id[p];
    }

    @Override
    public int getSize() {
        return id.length;
    }

    //O(1)复杂度
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void unionElements(int p, int q) {
        int findP = find(p);
        int findQ = find(q);

        if (findP == findQ) {
            return;
        }

        //将p的值都设置为q，O(n)复杂度
        for (int i = 0; i < id.length; i++) {
            if (id[i] == findP) {
                id[i] = findQ;
            }
        }
    }

}
