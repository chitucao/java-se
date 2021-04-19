package cn.chitucao.test;

/**
 * @author DennyFly
 * @since 2020/9/25 16:19
 */
public class TryCatchTest {
    public static void main(String[] args) {
        System.out.println(testReturn());
    }


    public static int testReturn() {

        try {
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 2;
        } finally {
            return 3;
        }
    }

}
