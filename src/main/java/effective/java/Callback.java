package effective.java;

import java.util.concurrent.TimeUnit;

/**
 * @author xuweijsnj
 */
public interface Callback {

    public void callback();

}

/**
 * @author xuweijsnj
 */
class A implements Callback {

    private B b;

    public A(B b) {
        this.b = b;
    }

    public void ask() {
        new Thread(() -> {
            b.apply(this);
        }, "线程A").start();
    }

    @Override
    public void callback() {
        System.out.println("处理A中回调");
    }

    public static void main(String[] args) {
        new C(new A(new B())).ask();
    }
}

/**
 * @author xuweijsnj
 */
class B {

    public void apply(Callback c) {
        System.out.println("接受请求");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        c.callback();
    }
}

/**
 * @author xuweijsnj
 */
class C implements Callback {
    private A a;

    public C(A a) {
        this.a = a;
    }

    public void ask() {
        a.ask();
    }

    @Override
    public void callback() {
        a.callback();
        System.out.println("处理C中回调");
    }

}
