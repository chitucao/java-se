package cn.chitucao.designprinciple.simpleresponsibility.method;

/**
 * Created by Tom on 2020/2/16.
 */
public class Method {

    //错误的
    private void modifyUserInfo(String userName, String address) {
        userName = "Tom";
        address = "Changsha";
    }

    private void modifyUserInfo(String userName, String... fileds) {

    }

    private void modifyUserInfo(String userName, String address, boolean bool) {
        if (bool) {

        } else {

        }
    }

    //正确的
    private void modifyUserName(String userName) {

    }

    private void modifyAddress(String address) {

    }
}
