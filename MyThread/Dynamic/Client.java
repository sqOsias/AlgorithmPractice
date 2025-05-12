package MyThread.Dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// 接口
interface PaymentService {
    void pay(double amount);
}

// 实现类1：支付宝支付
 class AlipayService implements PaymentService {
    @Override
    public void pay(double amount) {
        System.out.println("支付宝支付: " + amount);
    }
}

// 实现类2：微信支付
class WechatPayService implements PaymentService {
    @Override
    public void pay(double amount) {
        System.out.println("微信支付: " + amount);
    }
}

// 动态代理客户端


// 统一日志处理器
class LoggingHandler implements InvocationHandler {
    private final Object target;

    public LoggingHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("【日志】" + target.getClass().getSimpleName() + " 开始执行");
        Object result = method.invoke(target, args);
        System.out.println("【日志】执行完成");
        return result;
    }
}

public class Client {
    public static void main(String[] args) {
        // 创建不同实现类的代理
        PaymentService proxy1 = createProxy(new AlipayService());
        PaymentService proxy2 = createProxy(new WechatPayService());

        proxy1.pay(100.0); // 代理支付宝
        proxy2.pay(200.0); // 代理微信支付
    }

    private static PaymentService createProxy(PaymentService target) {
        return (PaymentService) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                new Class[]{PaymentService.class},
                new LoggingHandler(target)
        );
    }
}