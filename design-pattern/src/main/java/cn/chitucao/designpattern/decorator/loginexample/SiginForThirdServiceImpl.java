package cn.chitucao.designpattern.decorator.loginexample;

/**
 * Created by Tom on 2019/3/17.
 */
public class SiginForThirdServiceImpl implements ISiginForThirdService {

    //传递静态引用
    private ISigninService signinService;

    public SiginForThirdServiceImpl(ISigninService signinService) {
        this.signinService = signinService;
    }


    //复用之前的方法 静态代理
    @Override
    public ResultMsg regist(String username, String password) {
        return signinService.regist(username, password);
    }

    //复用之前的方法 静态代理
    @Override
    public ResultMsg login(String username, String password) {
        return signinService.login(username, password);
    }


    //继承的方法，可以自己增强
    @Override
    public ResultMsg loginForQQ(String id) {
        return null;
    }

    @Override
    public ResultMsg loginForWechat(String id) {
        return null;
    }

    @Override
    public ResultMsg loginForToken(String token) {
        return null;
    }

    @Override
    public ResultMsg loginForTelphone(String telphone, String code) {
        return null;
    }

    @Override
    public ResultMsg loginForRegist(String username, String passport) {
        return null;
    }
}
