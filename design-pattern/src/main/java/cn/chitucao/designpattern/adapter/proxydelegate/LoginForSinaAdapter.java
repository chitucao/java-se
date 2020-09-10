package cn.chitucao.designpattern.adapter.proxydelegate;

import cn.chitucao.designpattern.adapter.extendstatic.ResultMsg;

/**
 * Created by Tom.
 */
public class LoginForSinaAdapter implements LoginAdapter {
    @Override
    public boolean support(Object adapter) {
        return adapter instanceof LoginForSinaAdapter;
    }
    @Override
    public ResultMsg login(String id, Object adapter) {
        return null;
    }
}
