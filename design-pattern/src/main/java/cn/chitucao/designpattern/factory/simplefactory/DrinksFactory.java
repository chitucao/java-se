package cn.chitucao.designpattern.factory.simplefactory;

/**
 * @author DennyFly
 * @since 2020/3/20 10:34
 */
public class DrinksFactory {

    public AbstractDrinks produceDrink(Class className) {
        try {
            return (AbstractDrinks) Class.forName(className.getName()).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
