package cn.chitucao.test;


import cn.chitucao.lombok.User;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * 参考资料
 * https://zhuanlan.zhihu.com/p/338718644
 */
public class SpelTest {

    User user = new User();
    EvaluationContext context = new StandardEvaluationContext();
    context.setVariable("user", user);

    ExpressionParser parser = new SpelExpressionParser();
    //使用.符号，访问user.car.name会报错，原因：user.car为空
    try {
        System.out.println(parser.parseExpression("#user.car.name").getValue(context, String.class));
    } catch (EvaluationException | ParseException e) {
        System.out.println("出错了：" + e.getMessage());
    }
    //使用安全访问符号?.，可以规避null错误
    System.out.println(parser.parseExpression("#user?.car?.name").getValue(context, String.class));

    Car car = new Car();
    car.setName("保时捷");
    user.setCar(car);

    System.out.println(parser.parseExpression("#user?.car?.toString()").getValue(context, String.class));

}
