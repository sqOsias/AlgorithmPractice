package MyThread;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy  {
    public static void main(String[] args) {
        // 创建真实对象
        UserService realService = new UserServiceImpl();

        // 创建调用处理器
        InvocationHandler handler = new LoggingHandler(realService);

        // 动态生成代理对象
        UserService proxy = (UserService) Proxy.newProxyInstance(
                realService.getClass().getClassLoader(),
                realService.getClass().getInterfaces(),
                handler
        );

        // 通过代理对象调用方法
        proxy.addUser("张三");
        proxy.deleteUser(1001);
    }

}

 interface UserService {
    void addUser(String name);
    void deleteUser(int id);
}

class UserServiceImpl implements UserService {
    @Override
    public void addUser(String name) {
        System.out.println("添加用户: " + name);
    }

    @Override
    public void deleteUser(int id) {
        System.out.println("删除用户ID: " + id);
    }
}

class LoggingHandler implements InvocationHandler {
    private Object target; // 真实对象

    public LoggingHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("[日志] 方法调用: " + method.getName());
        Object result = method.invoke(target, args); // 调用真实对象的方法
        System.out.println("[日志] 方法执行完成");
        return result;
    }
}
