package cn.chitucao.designprinciple.compositereuse;

/**
 * Created by Tom on 2020/2/17.
 */
public class MyOracleConnection extends DBConnection {
    @Override
    public String getConnection() {
        return "获取Oracle数据连接";
    }
}
