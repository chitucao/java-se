package cn.chitucao.designprinciple.liskovsutiution.simple;

/**
 * Created by Tom on 2020/2/16.
 */
public class SimpleTest {

    public static void resize(Rectangle rectangle){
        while (rectangle.getWidth() >= rectangle.getHeight()){
            rectangle.setHeight(rectangle.getHeight() + 1);
            System.out.println("Width:" +rectangle.getWidth() +",Height:" + rectangle.getHeight());
        }
        System.out.println("Resize End,Width:" +rectangle.getWidth() +",Height:" + rectangle.getHeight());
    }

    //长方形测试
//    public static void main(String[] args) {
//        Rectangle rectangle = new Rectangle();
//        rectangle.setWidth(20);
//        rectangle.setHeight(10);
//        resize(rectangle);
//    }

    public static void main(String[] args) {
        Square square = new Square();
        square.setLength(10);
        resize(square);
    }

}
