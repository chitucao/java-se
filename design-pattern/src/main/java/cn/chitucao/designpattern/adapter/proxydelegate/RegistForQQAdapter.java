package cn.chitucao.designpattern.adapter.proxydelegate;

import cn.chitucao.designpattern.adapter.extendstatic.ResultMsg;

/**
 * Created by Tom on 2019/3/16.
 */
public class RegistForQQAdapter implements RegistAdapter,LoginAdapter {
    @Override
    public boolean support(Object adapter) {
        return false;
    }

    @Override
    public ResultMsg login(String id, Object adapter) {
        return null;
    }
}
