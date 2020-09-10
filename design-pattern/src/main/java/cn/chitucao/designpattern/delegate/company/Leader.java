package cn.chitucao.designpattern.delegate.company;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tom.
 * Leader委派给下一级，这里有个map，映射多个命令和执行者的关系，按需委派 策略
 */
public class Leader implements IEmployee {

    private Map<String, IEmployee> targets = new HashMap<String, IEmployee>();

    public Leader() {
        targets.put("加密", new EmployeeA());
        targets.put("登录", new EmployeeB());
    }

    //项目经理自己不干活
    public void doing(String command) {
        targets.get(command).doing(command);
    }

}
