package cn.antsing.tree;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
       //Class.forName("cn.antsing.tree.A");//打印静态块
       // Runtime.getRuntime().getClass().getClassLoader().loadClass("cn.antsing.tree.A");//空指针异常
        // ClassLoader.getSystemClassLoader().loadClass("cn.antsing.tree.A");//不打印
        A a = new A();
        A a1 = new A();
    }
}

class A{
    static {
        System.out.println("static code block ");
    }

    public static String s="oooooooooo";
}
