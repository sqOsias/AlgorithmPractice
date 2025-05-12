package MyThread;

public class StaticProxyTest {
    public static void main(String[] args) {
        Person person = new Person();
        StaticProxy staticProxy = new StaticProxy(person);
        staticProxy.marry();
    }


}
interface MarryEvent {
    void marry();
}

class Person implements MarryEvent {
    @Override
    public void marry(){
        System.out.println("我要结婚了");
    }
}

class StaticProxy implements MarryEvent {
    private MarryEvent target; // 改为接口类型

    public StaticProxy(MarryEvent target) { // 接收接口类型
        this.target = target;
    }


    @Override
    public void marry(){
        System.out.println("代理开始");
        target.marry();
        System.out.println("代理结束");
    }

}