package cn.chitucao.designpattern.factory.factorymethod;

/**
 * @author DennyFly
 * @since 2020/3/20 10:49
 * 具体产品
 */
public class CoCoCola extends Cola {

    @Override
    protected void drinks() {
        System.out.println("Drinks cococoLa");
    }
}
