package cn.chitucao.designprinciple.liskovsutiution;

/**
 * Created by Tom on 2020/2/16.
 */
public class Square implements QuadRangle {
    private long length;

    public long getLength() {
        return length;
    }

    public void setLength(long length) {
        this.length = length;
    }

    @Override
    public long getWidth() {
        return length;
    }

    @Override
    public long getHeight() {
        return length;
    }
}
