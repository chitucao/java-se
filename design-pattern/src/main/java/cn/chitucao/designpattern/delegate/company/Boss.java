package cn.chitucao.designpattern.delegate.company;

/**
 * Created by Tom.
 * Boss委派给下一级的leader  这里是持有引用
 */
public class Boss {

    public void command(String command,Leader leader){
        leader.doing(command);
    }

}

