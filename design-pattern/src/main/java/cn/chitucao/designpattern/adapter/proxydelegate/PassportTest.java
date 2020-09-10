package cn.chitucao.designpattern.adapter.proxydelegate;

/**
 * Created by Tom.
 */
public class PassportTest {

    public static void main(String[] args) {

        IPassportForThird passportForThird = new PassportForThirdAdapter();

        passportForThird.loginForQQ("1323");


    }

}
