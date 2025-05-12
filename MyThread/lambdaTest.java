package MyThread;

public class lambdaTest {

    //静态内部类
    static class Like2 implements ILike{
        @Override
        public void lambda() {
            System.out.println("i like lambda2");
        }
    }

    public static void main(String[] args) {
        ILike like = new Like();
        like.lambda();

        ILike like2 = new Like2();
        like2.lambda();

        //局部内部类
        class Like3 implements ILike{
            @Override
            public void lambda() {
                System.out.println("i like lambda3");
            }
        }
        ILike like3 = new Like3();
        like3.lambda();

        //匿名内部类
        ILike like4 = new ILike() {
            @Override
            public void lambda() {
                System.out.println("i like lambda4");
            }
        };
        like4.lambda();

        //Lambda表达式
        ILike like5 = () -> {
            System.out.println("i like lambda5");
        };
        like5.lambda();

        ILove iLove = (String a) -> {System.out.println("ILove "+a);};
        iLove.love("Lambda");

        ILove iLove2 =  a-> {System.out.println("ILove "+a);};
        iLove2.love("Lambda2");

        ILove iLove3 =  a-> System.out.println("ILove "+a);
        iLove3.love("Lambda3");


        Thread thread = new Thread();

    }
}

//函数式接口：只能定义一个抽象方法
//对于函数式接口，我们可以用Lambda表达式来创建该接口的对象

interface ILike{
    void lambda();
}

interface ILove{
    void love(String a);
}

class Like implements ILike{
    @Override
    public void lambda() {
        System.out.println("i like lambda");
    }
}
