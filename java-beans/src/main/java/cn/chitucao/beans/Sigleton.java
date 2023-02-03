package cn.chitucao.beans;

/**
 * @author chitucao
 * @since 2022/11/18 17:30
 */
public class Sigleton {

    private volatile Sigleton lazy;

    private Sigleton() {

    }

    public Sigleton getInstance() {
        if (lazy == null) {
            synchronized (Sigleton.class) {
                if (lazy == null) {
                    return new Sigleton();
                }
            }
        }
        return lazy;
    }

}
