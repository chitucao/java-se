package cn.chitucao.designpattern.factory.factorymethod;

/**
 * @author DennyFly
 * @since 2020/3/20 10:51
 */
public class MainTest {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        PepsiColaFactory colaFacotry = new PepsiColaFactory();
        PepsiCola pepsiCola = colaFacotry.produce(PepsiCola.class);
        pepsiCola.drinks();
    }
}
