package cn.chitucao.designprinciple.compositereuse;

/**
 * Created by Tom on 2020/2/17.
 */
public class MySQLConnection extends DBConnection {
    @Override
    public String getConnection() {
        return "获取MySQL数据连接";
    }
}
