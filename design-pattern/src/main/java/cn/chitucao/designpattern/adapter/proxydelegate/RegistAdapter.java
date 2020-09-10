package cn.chitucao.designpattern.adapter.proxydelegate;

import cn.chitucao.designpattern.adapter.extendstatic.ResultMsg;

/**
 * Created by Tom on 2019/3/16.
 */
public interface RegistAdapter {
    boolean support(Object adapter);
    ResultMsg login(String id, Object adapter);
}
