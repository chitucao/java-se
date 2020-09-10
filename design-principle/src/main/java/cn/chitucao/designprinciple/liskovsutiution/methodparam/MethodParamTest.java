package cn.chitucao.designprinciple.liskovsutiution.methodparam;

import java.util.HashMap;

/**
 * Created by Tom on 2020/2/16.
 */
public class MethodParamTest {
    public static void main(String[] args) {
        // 子类执行
        Child child = new Child();
        HashMap hashMap = new HashMap();
        child.method(hashMap);

        //父类执行
        Base base = new Base();
        base.method(hashMap);
    }
}
